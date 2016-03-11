package ovh.matrix.mascotas;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String POSITION = "ovh.matrix.mascotas.POSITION";
    public static final String IMG_RES = "ovh.matrix.mascotas.IMG_RES";

    int[] res_images = new int[] {
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7,
    };


    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pagMain);
        ImageAdapter imageAdapter = new ImageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(imageAdapter);
    }

    public static class MascotaFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            Bundle args = getArguments();
            final int position = args.getInt(POSITION);
            int img_res = args.getInt(IMG_RES);

            AppCompatImageView imageView = (AppCompatImageView) inflater.inflate(R.layout.view_mascota, container, false);
            imageView.setImageResource(img_res);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
            });

            return imageView;
        }
    }

    public class ImageAdapter extends FragmentStatePagerAdapter {

        public ImageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Bundle args = new Bundle();
            args.putInt(POSITION, position);
            args.putInt(IMG_RES, res_images[position]);

            MascotaFragment mascotaFragment = new MascotaFragment();
            mascotaFragment.setArguments(args);

            return mascotaFragment;
        }

        @Override
        public int getCount() {

            return res_images.length;
        }
    }
}
