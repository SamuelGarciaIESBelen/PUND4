/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;

/**
 * Clase que define el comportamiento del objeto Apuesta
 *
 * @author SamuelGZ
 */
public class Apuesta {

    /**
     * Getter para los goles del equipo local
     *
     * @return goles_local
     */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Setter para los goles del equipo local
     *
     * @param goles_local
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * Getter para los goles del equipo visitante
     *
     * @return goles_visitante
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Setter para los goles del equipo visitante
     *
     * @param goles_visitante
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Getter para el dinero apostado
     *
     * @return apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Setter para el dinero apostado
     *
     * @param apostado
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    protected int dinero_disp;
    protected int goles_local;
    protected int goles_visitante;
    protected int apostado;

    /**
     * Constructor por defecto
     */
    public Apuesta() {
    }

    /**
     * Contructor con parámetros
     *
     * @param dinero_disp
     * @param goles_local
     * @param goles_visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }

    /**
     * Método para obtener el valor del atributo dinero_disp
     *
     * @return
     */
    public int getDinero_disp() {
        return dinero_disp;
    }

    /**
     * Método para modificar el valor del atributo dinero_disp
     *
     * @param dinero_disp
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para apostar. Permite elegir la cantidad a apostar, no pudiendo
     * ser inferior a 1 ni superior a tu saldo disponible Este método será
     * probado con JUnit
     *
     * @param dinero
     * @throws Exception
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }

    /**
     * Método que comprueba si se ha acertado el resultado del partido En caso
     * de que lo haya acertado devuelve true. Chequea que no se metan menos de 0
     * goles
     *
     * @param local
     * @param visitante
     * @return
     * @throws Exception
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }

    /**
     * Método para cobrar la apuesta. Comprueba que se acertó el resultado y, en
     * ese caso, añade el valor apostado multiplicado por 10 al saldo disponible
     * Este método se va a probar con Junit
     *
     * @param cantidad_goles_local
     * @param cantidad_goles_visit
     * @throws Exception
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}
