package com.tmwdevelopments.barkeep;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tmwdevelopments.barkeep.cocktails.Cocktail;


/**
 * A fragment representing a single Cocktail detail screen.
 * This fragment is either contained in a {@link CocktailListActivity}
 * in two-pane mode (on tablets) or a {@link CocktailDetailActivity}
 * on handsets.
 */
public class CocktailDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private final String test2 = "afl";

    /**
     * The dummy content this fragment is presenting.
     */
    private Cocktail cocktail;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CocktailDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CollapsingToolbarLayout appBarLayout;

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
//            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            cocktail = Cocktail.cocktailMap.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(cocktail.getCocktailName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cocktail_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (cocktail != null) {
            StringBuilder ingredients = new StringBuilder();
            StringBuilder directions = new StringBuilder();
            for (int i = 0; i < cocktail.getIngredients().size(); i++){
                if (i != cocktail.getIngredients().size()-1) {
                    ingredients.append("• " + cocktail.getIngredients().get(i) + "\n\n");
                }
                else{
                    ingredients.append("• " + cocktail.getIngredients().get(i));
                }
            }

            for (int i = 0; i < cocktail.getDirections().size(); i++){
                if (i != cocktail.getDirections().size() - 1) {
                    directions.append("• " + cocktail.getDirections().get(i) + "\n\n");
                }
                else{
                    directions.append("• " + cocktail.getDirections().get(i));
                }
            }
            ((TextView) rootView.findViewById(R.id.cocktail_ingredients)).setText(ingredients.toString());
            ((TextView) rootView.findViewById(R.id.cocktail_directions)).setText(directions.toString());
        }

        return rootView;
    }
}
