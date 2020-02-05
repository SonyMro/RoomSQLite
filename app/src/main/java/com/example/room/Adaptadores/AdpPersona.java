package com.example.room.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.room.Entidades.Persona;
import com.example.room.R;

import java.util.List;
//Esta clase nos ayuda ha llenar nuestro ListView
public class AdpPersona extends BaseAdapter {
    private Context context; //Creamos un contex para pasarsolo como parametro
    private int layout;//Creamos nuestro un entero para cada item
    private List<Persona> personas;//Creamos un list de personas para llenar nuestro listview

    //No retornara el numero de registros que resiba nnuestro list
    @Override
    public int getCount() {
        return personas.size();
    }
    //Creamos un constructor para posarle nuestros valores
    public AdpPersona(Context context, int layout, List<Persona> personas) {
        this.context = context;
        this.layout = layout;
        this.personas = personas;
    }
    //Obtenemos el item de nuestro la lista
    @Override
    public Object getItem(int position) {
        return this.personas.get(position);
    }
    //Obtnemos es id del item selecionado
    @Override
    public long getItemId(int position) {
        return position;
    }
    //Este metodo es el mas importante ya que es este vamos ha llenar nuestro listView con los datos de la base de datos
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder; //Instanciamos nuestra subclase esto es para que el scroll nos funcione bien
        if (convertView == null) {//Preguntamos si el objeto no viene vacio
            //Con el layout inflate empezamos a llenar nuestro listView le pasamos como parametro el contexto
            LayoutInflater inflater = LayoutInflater.from(this.context);
            //Ahora con por cada item vamos agregarlo a nuestro viewGrup
            convertView = inflater.inflate(this.layout, null);
            //Inicializamos nuestra clase
            holder = new ViewHolder();
            //LLamamos los atributos de la subclase y relacionamos con nuestros componentes de item_persona
            holder.nombreview = (TextView) convertView.findViewById(R.id.lblNombre);
            holder.idview = (TextView) convertView.findViewById(R.id.lblId);
            holder.apeview = (TextView) convertView.findViewById(R.id.lblApe);
            holder.dniview = (TextView) convertView.findViewById(R.id.lblDni);
            holder.edadview = (TextView) convertView.findViewById(R.id.lblEdad);
            //Cremos nuestro item y lo añadimos a la lista
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }//Llenamos nuestros TextView Con nuestros datos del list
        //Asignamos le valores del item con el del list
        Persona currenPersona = personas.get(position);
        holder.nombreview.setText(currenPersona.getNombre());
        holder.idview.setText(String.valueOf(currenPersona.getId()));
        holder.apeview.setText(currenPersona.getApellido());
        holder.dniview.setText(currenPersona.getDni());
        holder.edadview.setText(currenPersona.getEdad());
        return convertView;//Retornamos la vista
    }

    static class ViewHolder {//Esta clase nos ayudara para tratar nuestros objetos nulos
        //Declaramos todos las campos de nuestra clase Persona
        private TextView idview;//
        private TextView nombreview;
        private TextView apeview;
        private TextView dniview;
        private TextView edadview;
    }
}
