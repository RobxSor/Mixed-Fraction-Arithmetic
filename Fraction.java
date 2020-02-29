package edu.slu.MidtermProject1;

// Name: Roby F. Soriano
// Date: 02/27/2020
// Schedule: TTH 3:00 - 4:30 PM
// Room: D524

/**
 * The edu.slu.MidtermProject1.Fraction class, a template for a fraction that has the form numerator/denominator.
 *
 * @author Roby F. Soriano
 * @since 01/30/2020
 */
public class Fraction {
    /**
     * This is the "numerator" property of the {@link Fraction} class.
     */
    private int numerator;

    /**
     * This is the "denominator" property of the {@link Fraction} class.
     */
    private int denominator;

    /**
     * This becomes the default constructor (since it has no arguments).
     * <p>This constructor allows a edu.slu.MidtermProject1.Fraction with an equivalent numeric value of zero to be created.
     * This becomes the default constructor (since it has no arguments). </p>
     * Example of Usage: edu.slu.MidtermProject1.Fraction myFraction = new edu.slu.MidtermProject1.Fraction();
     *
     * @author Roby Soriano [Prog 2 (Lab) TTH D524]
     * @since 01/30/2020
     */
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * This constructor creates a edu.slu.MidtermProject1.Fraction with the specified whole number as its initial value.
     * <p>This constructor automatically assigns 1 to the denominator (denominator = 1) if the user has a whole number value instead of performing
     * arithmetic operations with fractions.</p>
     * Example of Usage: edu.slu.MidtermProject1.Fraction myFraction = new edu.slu.MidtermProject1.Fraction(24);
     *
     */
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * This constructor creates a edu.slu.MidtermProject1.Fraction using the explicit numerator and denominator values.
     * <p>Example of usage: edu.slu.MidtermProject1.Fraction myFraction = new edu.slu.MidtermProject1.Fraction(8, 24);</p>
     *
     * @param numerator   This is the numerator of the fraction.
     * @param denominator This is the denominator of the fraction.
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * This is used to access data stored in numerator data member.
     *
     * @return Returns the value of the numerator.
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * This is used to set the numerator of the fraction.
     *
     * @param numerator This is the value needed for the numerator of the fraction.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * This is used to access data stored in denominator data member.
     *
     * @return Returns the value of the denominator.
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * This is used to set the denominator of the fraction.
     *
     * @param denominator This is the value needed for the denominator of the fraction.
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * This is used to return the answer of the fraction in a String.
     *
     * @return Returns the numerator and denominator of the fraction in its typical fraction form.
     */
    public String toString() {
        String result = "";
        if (this.numerator == 0) {
            result = result + "0";
        } else {
            if (this.denominator == 1) {
                result = result + this.numerator;
            } else {
                result = this.numerator + "/" + this.denominator;
            }
        }
        return result;
    }

    /**
     * This method is used to simplify a fraction.
     * @return Returns the reduced (simplest) form of this fraction.
     */
    public Fraction reduce() {
        Fraction r= new Fraction();
        int gcf = computeGCF();
        int newN = numerator/gcf;
        int newD = denominator/gcf;
        r.setNumerator(newN);
        r.setDenominator(newD);
        return  r;
    }

    public Fraction reduce2() {
        int gcf = computeGCF();
        int newN = numerator/gcf;
        int newD = denominator/gcf;
        Fraction r = new Fraction(newN, newD);
        return r;
    }

    private int computeGCF() {
        int gcf = 1;
        int lesser = 1;
        boolean found = false;
        lesser = computeLesser(Math.abs(numerator), Math.abs(denominator));
        for (int candidate = lesser; (candidate >= 1 && !found); candidate--) {
            if (Math.abs(numerator)%candidate == 0 && Math.abs(denominator)%candidate == 0) {
                found = true;
                gcf = candidate;
            }
        }
        return gcf;
    }

    // Returns the lesser integer between n1 and n2.
    private int computeLesser(int n1, int n2) {
        int lesser = n1;
        if (n1<n2) {
            lesser = n1;
        } else {
            lesser = n2;
        }
        return lesser;
    }

    /**
     * This is used to compute the decimal value (floating value) of the fraction.
     *
     * @return Returns the computed decimal value of the fraction.
     */
    public double toDecimal() {
        return (double) this.numerator / this.denominator;
    }

    /**
     * This method is used to add fractions.
     *
     * @param other This is the second fraction that will be added to the first fraction (the "this" fraction).
     * @return Returns the sum of the first fraction and the second fraction.
     */
    public Fraction add(Fraction other) {
        int num = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
        int den = (this.getDenominator() * other.getDenominator());
        Fraction s = new Fraction(num, den);
        s.reduce();
        return s;
    }

    /**
     * This method is used to subtract fractions.
     *
     * @param other This is the second fraction that will be subtracted to the first fraction (the "this" fraction).
     * @return Returns the difference of the first fraction and the second fraction.
     */
    public Fraction subtract(Fraction other) {
        int num = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator());
        int den = (this.getDenominator() * other.getDenominator());
        Fraction d = new Fraction(numerator, den);
        d.reduce();
        return d;
    }

    /**
     * This method is used to multiply fractions.
     *
     * @param other This is the second fraction that will be multiplied to the first fraction (the "this" fraction).
     * @return Returns the product of the first fraction and the second fraction.
     */
    public Fraction multiplyBy(Fraction other) {
        int num = this.getNumerator() * other.getNumerator();
        int den = this.getDenominator() * other.getDenominator();
        Fraction p = new Fraction(numerator, den);
        p.reduce();
        return p;
    }

    /**
     * This method is used to divide fractions.
     *
     * @param other This is the second fraction that will be divided to the first fraction (the "this" fraction).
     * @return Returns the quotient of the first fraction and the second fraction.
     */
    public Fraction divideBy(Fraction other) {
        int tempNumerator = this.getNumerator() * other.getDenominator();
        int tempDenominator = this.getDenominator() * other.getNumerator();
        Fraction q = new Fraction(tempNumerator, tempDenominator);
        q.reduce();
        return q;
    }

    /**
     * Returns a mixed number that is equivalent to this fraction.
     */
    public MixedNumber toMixedNumber() {
        int whole = numerator/denominator;
        int numFractionPart = numerator % denominator;
        MixedNumber m = new MixedNumber(whole, new Fraction(numFractionPart, denominator));
        return m;
    }

}
