package foodfindder.jacob.food_finder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jacob on 7/7/18.
 */

public class Ingredient_List_Adapter extends ArrayAdapter<Ingredient> {

    private static class ViewHolder {
        TextView name;
    }

    public Ingredient_List_Adapter(Context context, IngredientsList list) {
        super(context, R.layout.item_ingredient, list.getIngredientList());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Ingredient ingredient = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_ingredient, parent, false);
            viewHolder.name = convertView.findViewById(R.id.ingredient_part);
            viewHolder.name.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    setDescriptionToSelectedIngredient(ingredient, v);
                }
            });
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.name.setText(ingredient.name);
        // Return the completed view to render on screen
        return convertView;
    }

    private void setDescriptionToSelectedIngredient(Ingredient selectedIngredient, View view)
    {
        TextView description = view.findViewById(R.id.description_text_view);

    }
}
