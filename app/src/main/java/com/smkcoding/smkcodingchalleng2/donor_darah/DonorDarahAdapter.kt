import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.data_donor_darah.Data
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.donor_darah_item.*


class DonorDarahAdapter(private val context: Context, private val items:
List<Data>, private val listener: (Data)-> Unit) :
    RecyclerView.Adapter<DonorDarahAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.donor_darah_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: Data, listener: (Data) -> Unit) {
            txtRencana.text = item.rencanaDonor
            txtAlamat.text = item.alamat
            txtDaerahj.text = item.instansi
//            Log.d("rejepolo", item.alamat)

            containerView.setOnClickListener { listener(item) }
        }
    }
}