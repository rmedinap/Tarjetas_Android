package pe.gob.saludpol.listahttp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.gob.saludpol.listahttp.R;
import pe.gob.saludpol.listahttp.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> lista;

    public PersonAdapter(List<Person> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_card, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder personViewHolder, int i) {
        personViewHolder.txtNombre.setText("Nombre: "+lista.get(i).getNombre());
        personViewHolder.txtDNI.setText("DNI: "+lista.get(i).getDni());
        personViewHolder.txtEdad.setText(String.valueOf(lista.get(i).getEdad()));
        personViewHolder.imgFoto.setImageResource(lista.get(i).getIdfoto());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView txtNombre;
        private TextView txtDNI;
        private TextView txtEdad;
        private CardView personCardView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgPhoto);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtDNI = (TextView) itemView.findViewById(R.id.txtDni);
            txtEdad = (TextView) itemView.findViewById(R.id.txtEdad);
            personCardView = (CardView) itemView.findViewById(R.id.personCardView);
        }
    }
}
