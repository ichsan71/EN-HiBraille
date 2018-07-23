package id.or.codelabs.belajarbraille.learn_punctuation;

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
import id.or.codelabs.belajarbraille.data.TandaBacaModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class LearnPunctuationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements Filterable{

    private Context context;
    private List<TandaBacaModel> tandaBacaDataSet;
    private List<TandaBacaModel> tandaBacaDataSet2;
    private TandaBacaListener tandaBacaListener;

    public LearnPunctuationAdapter(Context context, List<TandaBacaModel> tandaBacaDataSet,
                                   TandaBacaListener tandaBacaListener) {
        this.context = context;
        this.tandaBacaDataSet = tandaBacaDataSet;
        this.tandaBacaDataSet2 = tandaBacaDataSet;
        this.tandaBacaListener = tandaBacaListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_punctuation, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TandaBacaModel model = tandaBacaDataSet2.get(position);
        ((ViewHolderItem) holder).imageTandaBaca.setImageDrawable(context.getResources()
                .getDrawable(model.getImageTandaBaca()));
        ((ViewHolderItem) holder).nameTandaBaca.setText(model.getNameTandaBaca());
        ((ViewHolderItem) holder).brailleDotsTandaBaca.setText(model.getBrailleDotsTandaBaca());
    }

    @Override
    public int getItemCount() {
        return tandaBacaDataSet2.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    tandaBacaDataSet2 = tandaBacaDataSet;
                } else {
                    List<TandaBacaModel> filterList = new ArrayList<>();
                    for (TandaBacaModel tandaBacaModel : tandaBacaDataSet) {
                        {
                            if (tandaBacaModel.getNameTandaBaca().toLowerCase().contains(charString) ||
                                    tandaBacaModel.getNameTandaBaca().contains(charString) ||
                                    tandaBacaModel.getNameTandaBaca().toUpperCase().contains(charString)) {
                                filterList.add(tandaBacaModel);
                            }

                        }
                    }
                    tandaBacaDataSet = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = tandaBacaDataSet;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                tandaBacaDataSet2 = (List<TandaBacaModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageTandaBaca;
        TextView nameTandaBaca;
        TextView brailleDotsTandaBaca;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imageTandaBaca = itemView.findViewById(R.id.learnpunctuation_imageview_punctuation);
            nameTandaBaca = itemView.findViewById(R.id.learnpunctuation_textview_symbol_name);
            brailleDotsTandaBaca = itemView.findViewById(R.id.learnpunctuation_textview_braille_dots);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            tandaBacaListener.onTandaBacaClick((tandaBacaDataSet2.get(getAdapterPosition())));
        }

    }

    public void replaceData(List<TandaBacaModel> tandaBacaDataSet) {
        this.tandaBacaDataSet = tandaBacaDataSet;
        this.tandaBacaDataSet2 = tandaBacaDataSet;
        notifyDataSetChanged();
    }
    public interface TandaBacaListener{
        void onTandaBacaClick(TandaBacaModel tandaBacaModel);
    }
}
