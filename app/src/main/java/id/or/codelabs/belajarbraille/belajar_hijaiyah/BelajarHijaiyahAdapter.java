package id.or.codelabs.belajarbraille.belajar_hijaiyah;

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
import id.or.codelabs.belajarbraille.data.HijaiyahModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarHijaiyahAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements Filterable {

    private Context context;
    private List<HijaiyahModel> hijaiyahDataSet;
    private List<HijaiyahModel> hijaiyahDataSet2;
    private HijaiyahListener hijaiyahListener;

    public BelajarHijaiyahAdapter(Context context, List<HijaiyahModel> hijaiyahDataSet,
                                  HijaiyahListener hijaiyahListener) {
        this.context = context;
        this.hijaiyahDataSet = hijaiyahDataSet;
        this.hijaiyahDataSet2 = hijaiyahDataSet;
        this.hijaiyahListener = hijaiyahListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_hijaiyah, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HijaiyahModel model = hijaiyahDataSet2.get(position);
        ((ViewHolderItem) holder).imageHijaiyah.setImageDrawable(context.getResources()
                .getDrawable(model.getImageHijaiyah()));
        ((ViewHolderItem) holder).nameHijaiyah.setText(model.getNameHijaiyah());
        ((ViewHolderItem) holder).brailleDotsHijaiyah.setText(model.getBrailleDotsHijaiyah());
    }

    @Override
    public int getItemCount() {
        return hijaiyahDataSet2.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    hijaiyahDataSet2 = hijaiyahDataSet;
                } else {
                    List<HijaiyahModel> filterList = new ArrayList<>();
                    for (HijaiyahModel hijaiyahModel : hijaiyahDataSet) {
                        {
                            if (hijaiyahModel.getNameHijaiyah().toLowerCase().contains(charString) ||
                                    hijaiyahModel.getNameHijaiyah().contains(charString) ||
                                    hijaiyahModel.getNameHijaiyah().toUpperCase().contains(charString)) {
                                filterList.add(hijaiyahModel);
                            }

                        }
                    }
                    hijaiyahDataSet = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = hijaiyahDataSet;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                hijaiyahDataSet2 = (List<HijaiyahModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageHijaiyah;
        TextView nameHijaiyah;
        TextView brailleDotsHijaiyah;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imageHijaiyah = itemView.findViewById(R.id.belajarhijaiyah_imageview_hijaiyah);
            nameHijaiyah = itemView.findViewById(R.id.belajarhijaiyah_textview_nama_simbol);
            brailleDotsHijaiyah = itemView.findViewById(R.id.belajarhijaiyah_textview_keterangan);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            hijaiyahListener.onHijaiyahClick(hijaiyahDataSet2.get(getAdapterPosition()));
        }

    }

    public void replaceData(List<HijaiyahModel> hijaiyahDataSet) {
        this.hijaiyahDataSet = hijaiyahDataSet;
        this.hijaiyahDataSet2 = hijaiyahDataSet;
        notifyDataSetChanged();
    }
    public interface HijaiyahListener{
        void onHijaiyahClick(HijaiyahModel hijaiyahModel);
    }
}
