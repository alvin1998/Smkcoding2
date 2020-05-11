import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smkcoding.smkcodingchalleng2.GithubUserItem
import com.smkcoding.smkcodingchalleng2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.profil_item.*


class ProfilAdapter(private val context: Context, private val items: List<GithubUserItem>, private val listener: (GithubUserItem)-> Unit) :
    RecyclerView.Adapter<ProfilAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.profil_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: GithubUserItem, listener: (GithubUserItem) -> Unit) {


            txtNegara.text = item.login



            containerView.setOnClickListener { listener(item) }
        }
    }

}