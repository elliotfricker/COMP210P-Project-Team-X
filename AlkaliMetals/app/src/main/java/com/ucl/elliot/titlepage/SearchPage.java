package com.ucl.elliot.titlepage;

//Here we are importing the methods required for the start page of the Alkali Metals application

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

//The AppCompatActivity class is used as a base class for activities that use the support library
// action bar. For this activity the adapter view is being implemented to populate the layout with
//views and runtime.

public class SearchPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //The spinner in the search page is being defined here as spinner, no specific name is required
    //as there is only one spinner within our application.

    Spinner spinner;

    //The text views used in the search page activity are set up here, these are used to display
    //the information for each alkali metal in the library. These will display different values
    //depending on which element has been selected by the spinner.

    TextView name;
    TextView symbol;
    TextView protonNo;
    TextView atomicWeight;
    TextView oxidationStates;
    TextView meltingPoint;
    TextView boilingPoint;
    TextView discoverer;

    //The strings for the information on the properties of the alkali metals are set up here,
    //arrays have been used here to store the specific value for each category for each alkali
    //metal that is stored in the library. Please note that for each string the first value in the
    //array is blank as this corresponds to the "(please select an element)" option on the spinner.

    String[]AMname={"","Lithium","Sodium","Potassium","Rubidium","Caesium","Francium"};
    String[]AMsymbol={"","Li","Na","K","Rb","Cs","Fr"};
    String[]AMprotonNo={"","3","11","19","37","55","87"};
    String[]AMatomicWeight={"","6.941","22.9898","39.0983","85.4678","132.905","223"};
    String[]AMoxidationStates={"","1","1,-1","1","1","1","1"};
    String[]AMmeltingPoint={"","180.54","97.72","63.38","39.31","28.44","N/A"};
    String[]AMboilingPoint={"","1342","883","759","688","671","N/A"};
    String[]AMdiscoverer={"","A.Arfwedson","H.Davy","H.Davy","W.Bunsen & R.Kirchoff","W.Bunsen & " +
            "R.Kirchoff","M.Perey",};

    //Through calling the super.onCreate(savedInstanceState) it runs the code in addition to the
    //existing code in the onCreate() of the parent class. The onCreate(Bundle) initializes our
    //activity. Here, we call the setContentView(int) which creates a window where we can place
    //our User Interphase and using the findViewById(int), the widgets in that User Interphase
    //are retrieved.

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        //This has been used to set up the toolbar at the top of the page and include the
        //"Alkali Metals Library" title within the toolbar as well.

        Toolbar mActionBarToolbar;
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Alkali Metals Library");

        //Below the spinner is found through it ID which has been defined content_search_page.xml

        spinner = (Spinner) findViewById(R.id.spinner);

        //The spinner has an on selected listener to make sure that the search page displays the
        //information required when an element is selected. The ArrayAdapter is used to supply the
        //spinner with the array of the items (elements) in the string resource file.

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.elements_list,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Below the text views for each property category for the alkali metals are found through
        //their IDs which have been defined in the xml file of content_search_page.

        name = (TextView) findViewById(R.id.textViewName);
        symbol = (TextView) findViewById(R.id.textViewSymbol);
        protonNo = (TextView) findViewById(R.id.textViewProtonNumber);
        atomicWeight = (TextView) findViewById(R.id.textViewAtomicWeight);
        oxidationStates = (TextView) findViewById(R.id.textViewOxidationStates);
        meltingPoint = (TextView) findViewById(R.id.textViewMP);
        boilingPoint = (TextView) findViewById(R.id.textViewBP);
        discoverer = (TextView) findViewById(R.id.textViewDiscoverer);
    }

    //This has been used to ensure that when nothing is selected in the spinner that the text views
    //used to display the properties of the alkali metals are left blank and do not display any
    //information.

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        name.setText("");
        symbol.setText("");
        protonNo.setText("");
        atomicWeight.setText("");
        oxidationStates.setText("");
        meltingPoint.setText("");
        boilingPoint.setText("");
        discoverer.setText("");
    }

    //In order to have the text views for the properties of each element display the correct
    //information for the selected element. When an element on the spinner is selected the on item
    //selected listener tells to search the array strings to find the required information and
    //display them in the correct text views. The AdapterView is used to populate the layout with
    //views at runtime. A subclass of the AdapterView class uses an Adapter to bind data to its
    //layout. There is also a toast set up to display the name of the element selected on the
    //spinner in a pop up text view that is on screen for a short period.

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int location, long id) {
        TextView myText = (TextView) view;
        Toast.makeText(this, "" + myText.getText(), Toast.LENGTH_SHORT).show();

        name.setText(AMname[location]);
        symbol.setText(AMsymbol[location]);
        protonNo.setText(AMprotonNo[location]);
        atomicWeight.setText(AMatomicWeight[location]);
        oxidationStates.setText(AMoxidationStates[location]);
        meltingPoint.setText(AMmeltingPoint[location]);
        boilingPoint.setText(AMboilingPoint[location]);
        discoverer.setText(AMdiscoverer[location]);

    }

}