package montacer.elfazazi.ejerc5.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import montacer.elfazazi.ejerc5.R;
import montacer.elfazazi.ejerc5.modelos.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoVH>{

    private List<Producto> objects;
    private int resource;
    private Context context;

    public ProductoAdapter(List<Producto> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productosView = LayoutInflater.from(context).inflate(resource,null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
          ViewGroup.LayoutParams.MATCH_PARENT,
          ViewGroup.LayoutParams.WRAP_CONTENT
        );
        productosView.setLayoutParams(lp);
        return new ProductoVH(productosView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {
        Producto producto = objects.get(position);

        holder.lbNombre.setText("producto:"+producto.getNombre());
        holder.lbCantidad.setText("cantidad: "+String.valueOf(producto.getCantidad()));


    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    private AlertDialog confirmUpdate(String titulo, Producto producto){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(titulo);
        builder.setCancelable(false);

        builder.setNegativeButton("NO", null);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

    public class ProductoVH extends RecyclerView.ViewHolder{

        TextView lbNombre, lbCantidad;
        ImageButton btnBasura;

        public ProductoVH(@NonNull View itemView) {
            super(itemView);

            lbNombre = itemView.findViewById(R.id.lbNombreProductosViewModel);
            lbCantidad = itemView.findViewById(R.id.lbCantidadProductosViewModel);
            btnBasura = itemView.findViewById(R.id.btnBasuraProductosModel);
        }
    }


}
