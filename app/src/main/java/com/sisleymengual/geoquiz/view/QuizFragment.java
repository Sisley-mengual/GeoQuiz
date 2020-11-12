package com.sisleymengual.geoquiz.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sisleymengual.BancoDePreguntas;
import com.sisleymengual.Pregunta;
import com.sisleymengual.geoquiz.R;


public class QuizFragment extends Fragment {
    private TextView mPreguntaTextView;
    private Button mCiertoButton;
    private Button mFalsoButton;
    private Button mAnteriorButton;
    private Button mSiguienteButton;
    private BancoDePreguntas mBanco;
    private Pregunta mPreguntaActual;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


    //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_quiz, container,false);
        mPreguntaTextView = view.findViewById(R.id.pregunta_text_view);
        mCiertoButton = view.findViewById(R.id.cierto_button);
        mFalsoButton = view.findViewById(R.id.falso_button);
        mAnteriorButton = view.findViewById(R.id.anterior_button);
        mSiguienteButton = view.findViewById(R.id.siguiente_button);
        mBanco = new BancoDePreguntas();
        mPreguntaActual = mBanco.get(0);
        actualizarPregunta();
        mCiertoButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            verificarRespuesta(true);
        }
        });

        mFalsoButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { verificarRespuesta(false);
        }
        });

        mAnteriorButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { mPreguntaActual = mBanco.previous(); actualizarPregunta();
        }
        });

        mSiguienteButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { mPreguntaActual = mBanco.next(); actualizarPregunta();
        }
        });






        return view;
    }

    private void actualizarPregunta() { mPreguntaTextView.setText(mPreguntaActual.getmTextoPregunta());
    }

    private void verificarRespuesta(boolean botonOprimido) { boolean respuesta = mPreguntaActual.getRespuestaEsVerdadera(); if (respuesta == botonOprimido) {
        Toast.makeText(
                getContext(), R.string.texto_respuesta_correcta, Toast.LENGTH_SHORT)
                .show();
    }
    else {
        Toast.makeText(
                getContext(), R.string.texto_respuesta_incorrecto, Toast.LENGTH_SHORT)
                .show();
    }
    }


}
