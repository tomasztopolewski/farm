/**
 * Klasa 'Cornfield' służy obsłudze pola.
 *
 * Zmienna typu całkowitego 'square' przechowuje liczbę metrów kwadratowych pola.
 * Zmienna typu zmiennoprzecinkowego 'cost' przechowuje cenę zakupu 1 m2.
 * Zmienna typu zmiennoprzecinkowego 'multiplier' przechowuje wartość liczbą,
 * którą należy pomnożyć, aby zakupić pole o p. rozszerzonym. (zmienna wyłączona)
 * Zmienna typu całkowitego 'occupiedSquare' przechowuje liczęb m2 zajętych pod uprawę.
 */

package pl.tomasztopolewski.farm.core;

public class Cornfield {
    // powierzhcnia pola wyrażona w liczbach całkowitych
    private int square;

    // koszt kupna 1m2 pola p. podstawowego
    private final float cost = 100;

    // mnożnik ceny dla pola p. rozszerzonego
    //private float multiplier;

    // przestrzeń zajęta pod uprawy
    private int occupiedSquare;


    public Cornfield(int square) {
        setSquare(square);
        setOccupiedSquare(0);
    }
    public Cornfield() {
        setSquare(0);
        setOccupiedSquare(0);
    }


    public int getSquare() {
        return square;
    }
    public void setSquare(int square) {
        this.square = square >= 0 ? square : 0;
    }
    public void addSquare(int square) {
        setSquare(this.square + square);
    }
    public void removeSquare(int square) {
        setSquare(this.square - square);
    }

    public float getCost() {
        return cost;
    }

    /*public float getMultiplier() { return multiplier; }
    public void setMultiplier(float multiplier) { this.multiplier = multiplier; }*/

    public int getOccupiedSquare() {
        return occupiedSquare;
    }
    public void setOccupiedSquare(int occupiedSquare) {
        this.occupiedSquare = this.occupiedSquare + occupiedSquare <= square && this.occupiedSquare - occupiedSquare >= 0 ? occupiedSquare : 0;
    }

}
