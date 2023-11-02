package montacer.elfazazi.ejerc5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

import montacer.elfazazi.ejerc5.adapter.ProductoAdapter;
import montacer.elfazazi.ejerc5.databinding.ActivityMainBinding;
import montacer.elfazazi.ejerc5.modelos.Producto;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Producto> listaCompra;
    private ProductoAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaCompra = new ArrayList<>();
        crearTarea();

        adapter = new ProductoAdapter(listaCompra, R.layout.producto_view_model, MainActivity.this);
        binding.contentMain.contenedor.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        binding.contentMain.contenedor.setLayoutManager(layoutManager);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void crearTarea() {
        for (int i = 0; i < 1000; i++) {
            listaCompra.add(new Producto(" "+i, (float) (i), i));
        }
    }
}