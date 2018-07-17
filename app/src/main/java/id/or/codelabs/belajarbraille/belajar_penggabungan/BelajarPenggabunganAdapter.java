package id.or.codelabs.belajarbraille.belajar_penggabungan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarPenggabunganAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements Filterable{

    private Context context;
    private List<PenggabunganModel> penggabunganDataSet;
    private List<PenggabunganModel> penggabunganDataSet2;
    private PenggabunganListener penggabunganListener;

    public BelajarPenggabunganAdapter(Context context, List<PenggabunganModel> penggabunganDataSet,
                                      PenggabunganListener penggabunganListener) {
        this.context = context;
        this.penggabunganDataSet = penggabunganDataSet;
        this.penggabunganDataSet2 = penggabunganDataSet;
        this.penggabunganListener = penggabunganListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_penggabungan, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PenggabunganModel model = penggabunganDataSet2.get(position);
        ((ViewHolderItem) holder).imagePenggabungan.setImageDrawable(context.getResources()
                .getDrawable(model.getImagePenggabungan()));
        ((ViewHolderItem) holder).namePenggabungan.setText(model.getNamePenggabungan());
        ((ViewHolderItem) holder).spellPenggabungan.setText(model.getSpellPenggabungan());
        ((ViewHolderItem) holder).brailleDotsPenggabungan.setText(model.getBrailleDotsPenggabungan());
    }

    @Override
    public int getItemCount() {
        return penggabunganDataSet2.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    penggabunganDataSet2 = penggabunganDataSet;
                } else {
                    List<PenggabunganModel> filterList = new ArrayList<>();
                    for (PenggabunganModel penggabunganModel : penggabunganDataSet) {
                        {
                            if (penggabunganModel.getNamePenggabungan().toLowerCase().contains(charString) ||
                                    penggabunganModel.getNamePenggabungan().contains(charString) ||
                                    penggabunganModel.getNamePenggabungan().toUpperCase().contains(charString)) {
                                filterList.add(penggabunganModel);
                            }

                        }
                    }
                    penggabunganDataSet = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = penggabunganDataSet;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                penggabunganDataSet2 = (List<PenggabunganModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagePenggabungan;
        TextView namePenggabungan;
        TextView spellPenggabungan;
        TextView brailleDotsPenggabungan;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imagePenggabungan = itemView.findViewById(R.id.belajarpenggabungan_imageview_penggabungan);
            namePenggabungan = itemView.findViewById(R.id.belajarpenggabungan_textview_nama_simbol);
            spellPenggabungan = itemView.findViewById(R.id.belajarpenggabungan_textview_cara_baca_simbol);
            brailleDotsPenggabungan = itemView.findViewById(R.id.belajarpenggabungan_textview_keterangan);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            penggabunganListener.onPenggabunganClick((penggabunganDataSet2.get(getAdapterPosition())));
        }

    }

    public void replaceData(List<PenggabunganModel> penggabunganDataSet) {
        this.penggabunganDataSet = penggabunganDataSet;
        this.penggabunganDataSet2 = penggabunganDataSet;
        notifyDataSetChanged();
    }
    public interface PenggabunganListener{
        void onPenggabunganClick(PenggabunganModel penggabunganModel);
    }
}
