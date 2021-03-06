import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.data_covid.CovidItem

import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.github_user_item.*


class GithubUserAdapter(private val context: Context, private val items:
List<CovidItem>, private val listener: (CovidItem)-> Unit) :
    RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.github_user_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: CovidItem, listener: (CovidItem) -> Unit) {
            Log.d("ades", "puki")
            txtProvinsi.text = item.attributes.provinsi
            txtPositif.text = item.attributes.kasusPosi.toString()
            txtSembuh.text = item.attributes.kasusSemb.toString()
            txtMati.text = item.attributes.kasusMeni.toString()
//            Glide.with(context).load("https://covid19.mathdro.id/api").into(imgUser)

            containerView.setOnClickListener { listener(item) }
        }
    }
}