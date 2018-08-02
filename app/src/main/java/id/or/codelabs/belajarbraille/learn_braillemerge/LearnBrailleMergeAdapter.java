package id.or.codelabs.belajarbraille.learn_braillemerge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.or.codelabs.belajarbraille.R;
import id.or.codelabs.belajarbraille.data.BrailleMergeModel;

/**
 * Created by FitriFebriana on 5/23/2018.
 */

public class LearnBrailleMergeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements Filterable{

    private Context context;
    private List<BrailleMergeModel> brailleMergeDataSet;
    private List<BrailleMergeModel> brailleMergeDataSet2;
    private BrailleMergeListener brailleMergeListener;

    public LearnBrailleMergeAdapter(Context context, List<BrailleMergeModel> brailleMergeDataSet,
                                    BrailleMergeListener brailleMergeListener) {
        this.context = context;
        this.brailleMergeDataSet = brailleMergeDataSet;
        this.brailleMergeDataSet2 = brailleMergeDataSet;
        this.brailleMergeListener = brailleMergeListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_braille_merge, null);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BrailleMergeModel model = brailleMergeDataSet2.get(position);
        ((ViewHolderItem) holder).imageBrailleMerge.setImageDrawable(context.getResources()
                .getDrawable(model.getImageBrailleMerge()));
        ((ViewHolderItem) holder).imageBrailleMerge.setContentDescription(model.getNameBrailleMerge() + "."
                + model.getSpellBrailleMerge() + "."
                + model.getBrailleDotsBrailleMerge() + ".");
    }

    @Override
    public int getItemCount() {
        return brailleMergeDataSet2.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    brailleMergeDataSet2 = brailleMergeDataSet;
                } else {
                    List<BrailleMergeModel> filterList = new ArrayList<>();
                    for (BrailleMergeModel brailleMergeModel : brailleMergeDataSet) {
                        {
                            if (brailleMergeModel.getNameBrailleMerge().toLowerCase().contains(charString) ||
                                    brailleMergeModel.getNameBrailleMerge().contains(charString) ||
                                    brailleMergeModel.getNameBrailleMerge().toUpperCase().contains(charString)) {
                                filterList.add(brailleMergeModel);
                            }

                        }
                    }
                    brailleMergeDataSet = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = brailleMergeDataSet;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                brailleMergeDataSet2 = (List<BrailleMergeModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageBrailleMerge;

        public ViewHolderItem(View itemView) {
            super(itemView);
            imageBrailleMerge = itemView.findViewById(R.id.learnbraillemerge_imageview_braille_merge);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            brailleMergeListener.onBrailleMergeClick((brailleMergeDataSet2.get(getAdapterPosition())));
        }

    }

    public void replaceData(List<BrailleMergeModel> brailleMergeDataSet) {
        this.brailleMergeDataSet = brailleMergeDataSet;
        this.brailleMergeDataSet2 = brailleMergeDataSet;
        notifyDataSetChanged();
    }
    public interface BrailleMergeListener{
        void onBrailleMergeClick(BrailleMergeModel penggabunganModel);
    }
}
