package coltonlachance.com.madskeletonapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**CustomViewPageAdapter
 * A custom adapter for a viewpager2
 * @author Colton LaChance
 */
public class CustomViewPageAdapter extends FragmentStateAdapter {

    public CustomViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**CreateFragment
     * A method that returns a "VPFragment" by default based on the current position of the viewpager
     * @param position
     * @return fragment
     */
    public Fragment createFragment(int position) {
        switch(position) {
            case 0: return VPFragment.newInstance(position,"Mercury",R.drawable.mercury);
            case 1: return VPFragment.newInstance(position,"Venus",R.drawable.venus);
            case 2: return VPFragment.newInstance(position,"Mars",R.drawable.mars);
            case 3: return VPFragment.newInstance(position,"Jupiter",R.drawable.jupiter);
            case 4: return VPFragment.newInstance(position,"Saturn",R.drawable.saturn);
            case 5: return VPFragment.newInstance(position,"Uranus",R.drawable.uranus);
            case 6: return VPFragment.newInstance(position,"Neptune",R.drawable.neptune);
            //Add more cases here
            default: return VPFragment.newInstance(position,"PLACEHOLDER",R.drawable.mercury);
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    } //Update this number to reflect amount of pages
}