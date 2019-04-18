package pe.gob.saludpol.listaapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.gob.saludpol.listaapp.R;
import pe.gob.saludpol.listaapp.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> lista;

    public PersonAdapter(List<Person> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder personViewHolder, int i) {

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

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtDNI = (TextView) itemView.findViewById(R.id.txtDni);
            txtEdad = (TextView) itemView.findViewById(R.id.txtEdad);
            personCardView = (CardView) itemView.findViewById(R.id.personCardView);
        }
    }
}
