package id.or.codelabs.belajarbraille.belajar_tandabaca;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class BelajarTandaBacaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<TandaBacaModel> tandaBacaDataSet;
    private TandaBacaListener tandaBacaListener;

    public BelajarTandaBacaAdapter(Context context, List<TandaBacaModel> tandaBacaDataSet,
                                   TandaBacaListener tandaBacaListener) {
        this.context = context;
        this.tandaBacaDataSet = tandaBacaDataSet;
        this.tandaBacaListener = tandaBacaListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_tanda_baca, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TandaBacaModel model = tandaBacaDataSet.get(position);
        ((ViewHolderItem) holder).imageTandaBaca.setImageDrawable(context.getResources()
                .getDrawable(model.getImageTandaBaca()));
        ((ViewHolderItem) holder).nameTandaBaca.setText(model.getNameTandaBaca());
        ((ViewHolderItem) holder).brailleDotsTandaBaca.setText(model.getBrailleDotsTandaBaca());
    }

    @Override
    public int getItemCount() {
        return tandaBacaDataSet.size();
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageTandaBaca;
        TextView nameTandaBaca;
        TextView brailleDotsTandaBaca;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imageTandaBaca = itemView.findViewById(R.id.belajartandabaca_imageview_tandabaca);
            nameTandaBaca = itemView.findViewById(R.id.belajartandabaca_textview_nama_simbol);
            brailleDotsTandaBaca = itemView.findViewById(R.id.belajartandabaca_textview_keterangan);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            tandaBacaListener.onTandaBacaClick((tandaBacaDataSet.get(getAdapterPosition()).getNameTandaBaca()));
        }

    }

    public void replaceData(List<TandaBacaModel> tandaBacaDataSet) {
        this.tandaBacaDataSet = tandaBacaDataSet;
        notifyDataSetChanged();
    }
    public interface TandaBacaListener{
        void onTandaBacaClick(String extra);
    }
}
