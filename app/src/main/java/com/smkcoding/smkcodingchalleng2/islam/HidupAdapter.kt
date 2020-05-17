import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.agama.IslamItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.hidup_sehat_item.*


class HidupAdapter(private val context: Context, private val items:
List<IslamItem>, private val listener: (IslamItem)-> Unit) :
    RecyclerView.Adapter<HidupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.hidup_sehat_item,
            parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: IslamItem, listener: (IslamItem) -> Unit) {
            Log.d("ades", Int.toString())
            txtNegara.text = item.nama
            Type.text = item.type
            Ayat.text = item.ayat.toString()
//            Glide.with(context).load("https://covid19.mathdro.id/api").into(imgUser)

            containerView.setOnClickListener { listener(item) }
        }
    }

}