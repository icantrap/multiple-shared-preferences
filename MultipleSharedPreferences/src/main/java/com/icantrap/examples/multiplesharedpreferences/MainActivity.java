package com.icantrap.examples.multiplesharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
        .add(R.id.container, new PlaceholderFragment())
        .commit();
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  /**
   * A placeholder fragment containing a simple view.
   */
  public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
    private Activity activity;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      activity = getActivity();

      View rootView = inflater.inflate(R.layout.fragment_main, container, false);

      Button button = (Button) rootView.findViewById(R.id.button);
      button.setOnClickListener(this);

      button = (Button) rootView.findViewById(R.id.button2);
      button.setOnClickListener(this);

      return rootView;
    }

    @Override
    public void onClick(View view) {
      String settingsName = null;

      switch (view.getId()) {
        case R.id.button:
          settingsName = "button-1";
          break;
        case R.id.button2:
          settingsName = "button-2";
          break;
      }

      Intent intent = new Intent(activity, SettingsActivity.class);
      intent.putExtra("name", settingsName);
      startActivity(intent);
    }
  }
}
