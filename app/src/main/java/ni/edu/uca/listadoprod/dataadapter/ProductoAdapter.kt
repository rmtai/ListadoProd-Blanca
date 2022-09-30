package ni.edu.uca.listadoprod.dataadapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.listadoprod.databinding.ActivityMainBinding
import ni.edu.uca.listadoprod.databinding.ItemlistaBinding
import ni.edu.uca.listadoprod.dataclass.Producto

class ProductoAdapter(
    val listProd:List<Producto>,
    private val onClickerVer:(Producto)->Unit,
    private val onClickerDel: (Int) -> Unit,
    private val onClickerEdit:(Int)->Unit
    ) :
    RecyclerView.Adapter<ProductoAdapter.ProductoHolder>(){
    inner class ProductoHolder(val binding: ItemlistaBinding):
            RecyclerView.ViewHolder(binding.root){

                fun cargar(
                    producto: Producto, onClickListener:(Producto)->Unit,
                    onClickerDel: (Int) -> Unit,
                    onClickerEdit: (Int) -> Unit
                ){
                    with(binding){
                        tvCodProd.text = producto.id.toString()
                        tvNombreProd.text = producto.nombre
                        tvPrecioProd.text = producto.precio.toString()
                        itemView.setOnClickListener{onClickListener(producto)}
                        binding.btnEliminar.setOnClickListener { onClickerDel(adapterPosition)}
                        binding.btnEditar.setOnClickListener { onClickerEdit(adapterPosition) }
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        val binding = ItemlistaBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false

        )
        return ProductoHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        holder.cargar(listProd[position], onClickerVer, onClickerDel, onClickerEdit)
    }

    override fun getItemCount(): Int = listProd.size


}