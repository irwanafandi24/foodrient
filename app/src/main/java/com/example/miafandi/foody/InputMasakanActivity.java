package com.example.miafandi.foody;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class InputMasakanActivity extends AppCompatActivity{

    private Button btn_jualMasakan, btn_tambahGambar;
    private EditText et_namaMasakan, et_harga, et_kategori;
    private TextView txtNamaFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_masakan);
        txtNamaFoto = (TextView) findViewById(R.id.txtNamaFoto);

        et_harga = (EditText) findViewById(R.id.et_harga);
        et_kategori = (EditText) findViewById(R.id.etKategori);
        et_namaMasakan = (EditText) findViewById(R.id.etNamaMasakan);

        btn_jualMasakan = (Button) findViewById(R.id.btnJualMasakan2);
        btn_tambahGambar = (Button) findViewById(R.id.btnTambahGambar);

        Toolbar tb= (Toolbar) findViewById(R.id.toolbarMenuJualMasak);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_jualMasakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_harga.getText().toString().equals("")){
                    et_harga.setError("Isi Harga");
                }else if(et_namaMasakan.getText().toString().equals("")){
                    et_namaMasakan.setError("Isi nama masakan");
                }else if(et_kategori.getText().toString().equals("")){
                    et_kategori.setError("Isi kategori");
                }
                else{
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(InputMasakanActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.activity_dialog_upload_makanan, null);

                    Button btn_ok = (Button) mView.findViewById(R.id.btnOk);

                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();

                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Toast.makeText(InputMasakanActivity.this, "I", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                    });

                }
            }
        });

    btn_tambahGambar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallery,0);
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImage = data.getData();
        String s= getRealPathFromURI(selectedImage);
        String name = s.substring(s.lastIndexOf("/") + 1);
        txtNamaFoto.setText(name);
//        upload(data, "masakan");
    }

    public String getRealPathFromURI(Uri contentUri) {

        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri,
                proj, // Which columns to return
                null, // WHERE clause; which rows to return (all rows)
                null, // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
