import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.smkcoding.smkcodingchalleng2.home_tampil.Home_img
import com.smkcoding.smkcodingchalleng2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.home_item.iv_foto

class HomeAdapter(private val context: Context, private val items : ArrayList<Home_img>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.home_item, parent, false)
    )
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }
    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Home_img) {

            Glide.with(this.containerView).load(item.img).diskCacheStrategy(DiskCacheStrategy.NONE ).skipMemoryCache(true).into(iv_foto)
        }
    }
}