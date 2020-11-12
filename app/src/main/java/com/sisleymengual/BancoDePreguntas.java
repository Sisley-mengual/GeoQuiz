package com.sisleymengual;
import java.util.ArrayList;
import java.util.List;

public class BancoDePreguntas {
    private List<Pregunta> mBanco; private int mPosicionActual;

    public BancoDePreguntas() { mBanco = new ArrayList<>(); mPosicionActual = -1; load();
    }

    private void load() { add(new Pregunta(
            "¿La Península de Yucatán se encuentra en el norte de México?", false));
        add(new Pregunta(
                "¿Nuestro sistema solar se ubica en la galaxia Vía Láctea?", true));
        add(new Pregunta(
                "¿El oceáno más grande de nuestro planeta es el Oceáno Pacífico?", true));
        add(new Pregunta(
                "¿Los vientos alisios soplan del noreste al suroeste?", true));
        add(new Pregunta(
                "¿El estado más grande de la República Mexicana es Sonora?", false));
    }

    public void add(Pregunta pregunta) { mBanco.add(pregunta);
        if (mBanco.size() == 1) { mPosicionActual = 0;
        }
    }

    public int size() { return mBanco.size();
    }

    public boolean isEmpty() { return mBanco.isEmpty();
    }

    public Pregunta get(int posicion) { return mBanco.get(posicion);
    }

    public Pregunta next() { if (isEmpty()) {
        return null;
    }
    else {
        if (mPosicionActual == size() - 1) { mPosicionActual = 0;
        }
        else {
            mPosicionActual++;
        }
        return mBanco.get(mPosicionActual);
    }
    }

    public Pregunta previous() { if (isEmpty()) {
        return null;
    }
    else {
        if (mPosicionActual == 0) { mPosicionActual = size() - 1;
        }
        else {
            mPosicionActual--;
        }
        return mBanco.get(mPosicionActual);
    }
    }
}


