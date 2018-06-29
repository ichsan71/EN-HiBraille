package id.or.codelabs.belajarbraille.belajar_penggabungan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.PenggabunganModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarPenggabunganAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<PenggabunganModel> penggabunganDataSet;
    private PenggabunganListener penggabunganListener;

    public BelajarPenggabunganAdapter(Context context, List<PenggabunganModel> penggabunganDataSet,
                                      PenggabunganListener penggabunganListener) {
        this.context = context;
        this.penggabunganDataSet = penggabunganDataSet;
        this.penggabunganListener = penggabunganListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_penggabungan, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PenggabunganModel model = penggabunganDataSet.get(position);
        ((ViewHolderItem) holder).imagePenggabungan.setImageDrawable(context.getResources()
                .getDrawable(model.getImagePenggabungan()));
        ((ViewHolderItem) holder).namePenggabungan.setText(model.getNamePenggabungan());
        ((ViewHolderItem) holder).brailleDotsPenggabungan.setText(model.getBrailleDotsPenggabungan());
    }

    @Override
    public int getItemCount() {
        return penggabunganDataSet.size();
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagePenggabungan;
        TextView namePenggabungan;
        TextView brailleDotsPenggabungan;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imagePenggabungan = itemView.findViewById(R.id.belajarpenggabungan_imageview_penggabungan);
            namePenggabungan = itemView.findViewById(R.id.belajarpenggabungan_textview_nama_simbol);
            brailleDotsPenggabungan = itemView.findViewById(R.id.belajarpenggabungan_textview_keterangan);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            penggabunganListener.onPenggabunganClick((penggabunganDataSet.get(getAdapterPosition()).getNamePenggabungan()));
        }

    }

    public void replaceData(List<PenggabunganModel> penggabunganDataSet) {
        this.penggabunganDataSet = penggabunganDataSet;
        notifyDataSetChanged();
    }
    public interface PenggabunganListener{
        void onPenggabunganClick(String extra);
    }
}
