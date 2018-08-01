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
import id.or.codelabs.belajarbraille.data.PunctuationModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class LearnPunctuationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements Filterable{

    private Context context;
    private List<PunctuationModel> punctuationDataSet;
    private List<PunctuationModel> punctuationDataSet2;
    private PunctuationListener punctuationListener;

    public LearnPunctuationAdapter(Context context, List<PunctuationModel> punctuationDataSet,
                                   PunctuationListener punctuationListener) {
        this.context = context;
        this.punctuationDataSet = punctuationDataSet;
        this.punctuationDataSet2 = punctuationDataSet;
        this.punctuationListener = punctuationListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_punctuation, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PunctuationModel model = punctuationDataSet2.get(position);
        ((ViewHolderItem) holder).imagePunctuation.setImageDrawable(context.getResources()
                .getDrawable(model.getImagePunctuation()));
        ((ViewHolderItem) holder).imagePunctuation.setContentDescription(model.getNamePunctuation() + "."
        + model.getBrailleDotsPunctuation() + ".");
//        ((ViewHolderItem) holder).namePunctuation.setText(model.getNamePunctuation());
//        ((ViewHolderItem) holder).brailleDotsPunctuation.setText(model.getBrailleDotsPunctuation());
    }

    @Override
    public int getItemCount() {
        return punctuationDataSet2.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    punctuationDataSet2 = punctuationDataSet;
                } else {
                    List<PunctuationModel> filterList = new ArrayList<>();
                    for (PunctuationModel punctuationModel : punctuationDataSet) {
                        {
                            if (punctuationModel.getNamePunctuation().toLowerCase().contains(charString) ||
                                    punctuationModel.getNamePunctuation().contains(charString) ||
                                    punctuationModel.getNamePunctuation().toUpperCase().contains(charString)) {
                                filterList.add(punctuationModel);
                            }

                        }
                    }
                    punctuationDataSet = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = punctuationDataSet;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                punctuationDataSet2 = (List<PunctuationModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagePunctuation;
        TextView namePunctuation;
        TextView brailleDotsPunctuation;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imagePunctuation = itemView.findViewById(R.id.learnpunctuation_imageview_punctuation);
//            namePunctuation = itemView.findViewById(R.id.learnpunctuation_textview_symbol_name);
//            brailleDotsPunctuation = itemView.findViewById(R.id.learnpunctuation_textview_braille_dots);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            punctuationListener.onPunctuationClick((punctuationDataSet2.get(getAdapterPosition())));
        }

    }

    public void replaceData(List<PunctuationModel> punctuationDataSet) {
        this.punctuationDataSet = punctuationDataSet;
        this.punctuationDataSet2 = punctuationDataSet;
        notifyDataSetChanged();
    }
    public interface PunctuationListener{
        void onPunctuationClick(PunctuationModel punctuationModel);
    }
}
