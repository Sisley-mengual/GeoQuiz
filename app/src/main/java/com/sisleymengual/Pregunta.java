package com.sisleymengual;

public class Pregunta {
    private String mTextoPregunta;
    private boolean mRespuestaEsVerdadera;

    public Pregunta(String textoPregunta, boolean respuestaEsVerdadera) {
        mTextoPregunta = textoPregunta;
        mRespuestaEsVerdadera = respuestaEsVerdadera;
    }

    public String getmTextoPregunta() {
        return mTextoPregunta;
    }
    public void setTextoPregunta(String textoPregunta) {mTextoPregunta = textoPregunta; }

    public boolean getRespuestaEsVerdadera(){return mRespuestaEsVerdadera;}

    public void setmRespuestaEsVerdadera(boolean respuestaEsVerdadera){
        this.mRespuestaEsVerdadera = respuestaEsVerdadera;
    }


}

