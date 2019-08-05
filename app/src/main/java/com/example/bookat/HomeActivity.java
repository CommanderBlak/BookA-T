package com.example.bookat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity  {

    CustomAdapter customAdapter = new CustomAdapter();


    ListView listView;

    int[] IMAGES = {
            R.drawable.avengers1,
            R.drawable.cap_america1,
            R.drawable.cap_america2,
            R.drawable.guardians_of_the_galaxy1,
            R.drawable.hulk1,
            R.drawable.iron_man1,
            R.drawable.iron_man2,
            R.drawable.iron_man3,
            R.drawable.overlord_ver2,
            R.drawable.thor1,
            R.drawable.thor2,
    };

    String[] TITLES = {
            "The Avengers (2012)",
            "Captain America (2011)",
            "Captain America 2 (2014)",
            "Guardians of The Galaxy(2012)",
            "The Incredible Hulk (2014)",
            "Iron Man (2008)",
            "Iron Man 2 (2010)",
            "Iron Man 3 (2013)",
            "Overlord (2018)",
            "Thor (2011)",
            "Thor 2 (2013)",
    };

    String[] DESCRIPTIONS = {
            "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and...",
            "Steve Rogers, a rejected military soldier transforms into Captain America after taking a dose of a \"Super-Soldier serum\"... ",
            "As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D. ...",
            "A group of intergalactic criminals must pull together to stop a fanatical warrior with...",
            "Bruce Banner, a scientist on the run from the U.S. Government, must find a cure for the monster he turns into...",
            "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor...",
            "With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful...     ",
            "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of...",
            "A small group of American soldiers find horror behind enemy lines on the eve of D-Day...",
            "The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he...",
            "When Dr. Jane Foster (Natalie Portman) gets cursed with a powerful entity known as the Aether...",
    };

    String[] RUNTIME = {
            "PG-13 | 143 min | Action, Adventure, Sci-Fi",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi",
            "PG-13 | 136 min | Action, Adventure, Sci-Fi",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi",
            "PG-13 | 2h 6min | Action, Adventure, Sci-Fi",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi",
            "R | 1h 50min | Action, Adventure, Horror",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi",
            "PG-13 | 124 min | Action, Adventure, Sci-Fi"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        getSupportActionBar().hide(); //this code removes the Title Bar

        listView = (ListView) findViewById(R.id.listView);


        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                try {
//                    showDialog();
//                } catch (Exception e) {
//                    Toast.makeText(HomeActivity.this, "No Dialog", Toast.LENGTH_SHORT).show();;
//                }
                Intent dialogIntent = new Intent(getApplicationContext(), Dialog.class);
                dialogIntent.putExtra("poster", IMAGES[position]);
                dialogIntent.putExtra("title", TITLES[position]);
                dialogIntent.putExtra("runtime", RUNTIME[position]);
                startActivity(dialogIntent);

            }
        });

    }




    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_layout, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView description = (TextView) convertView.findViewById(R.id.description);

            imageView.setImageResource(IMAGES[position]);
            title.setText(TITLES[position]);
            description.setText(DESCRIPTIONS[position]);

            return convertView;
        }
    }

}
