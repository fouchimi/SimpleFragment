package example.com.fragments;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import example.com.fragments.data.Flower;


public class MainActivity extends ActionBarActivity implements FlowerListFragment.Callbacks {

    public static final String FLOWER_BUNDLE = "FLOWER_BUNDLE";
    private static final int REQUEST_CODE = 1001;

    private boolean isTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.detailContainer) != null){
            isTwoPane = true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {

/*            ScreenUtility utility = new ScreenUtility(this);
            String output = "Width: " + utility.getDpWidth() + ", " +
                    "Height: " + utility.getDpHeight();

            Toast.makeText(this, output, Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(output)
                    .setTitle("Dimensions")
                    .create()
                    .show();*/

            MyDialogFragment dialog = new MyDialogFragment();
            Bundle b = new Bundle();
            b.putString("message", "I love you Nina");
            dialog.setArguments(b);
            dialog.show(getSupportFragmentManager(), "MyDialog");


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(Flower flower) {
        Bundle b = flower.toBundle();
        if(isTwoPane){
            FlowerDetailFragment fragment = new FlowerDetailFragment();
            fragment.setArguments(b);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detailContainer, fragment)
                    .commit();
        }else {
            Intent intent = new Intent(this, FlowerDetailActivity.class);
            intent.putExtra(FLOWER_BUNDLE, b);
            startActivityForResult(intent, REQUEST_CODE);
        }

    }
}
