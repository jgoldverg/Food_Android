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
    private int act;

    private static class ViewHolder {
        TextView name;
    }

    public Ingredient_List_Adapter(Context context, IngredientsList list) {
        super(context, R.layout.item_ingredient, list.getIngredientList());
    }

    public void setAct(int act){
        this.act = act;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Ingredient ingredient = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
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
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(ingredient.name);
        return convertView;
    }

    private void setDescriptionToSelectedIngredient(Ingredient selectedIngredient, View view)
    {
        TextView description = view.findViewById(R.id.description_text_view);

    }
}
