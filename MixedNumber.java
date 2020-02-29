// Names: Roby F. Soriano & Missy Mae Laarnie S. Layague
// Date: February 11, 2020
// Schedule: TTH 3:00 - 4:30 PM
// Room: D524

package edu.slu.MidtermProject1;

/**
 * The MixedFraction class, a template for a mixed fraction that has the form "whole numerator/denominator".
 * And also, this class extends the super class {@link Fraction}.
 *
 * @author Roby Soriano and Missy Mae Laarnie Layague
 * @since February 11, 2020
 */
public class MixedNumber extends Fraction {

    private int wholePart;
    private Fraction fractionPart;

    /**
     * This becomes the default constructor (since it has no arguments).
     * <p>This constructor allows a Fraction with an equivalent numeric value of zero to be created.
     * This becomes the default constructor (since it has no arguments). </p>
     * Example of Usage: MixedFraction myFraction = new MixedFraction();
     */
    public MixedNumber() {
        wholePart = 0;
        fractionPart = new Fraction();
    }

    /**
     * Constructs a mixed number with a given whole number part and fraction part.
     */
    public MixedNumber(int w, Fraction f) {
        wholePart = w;
        fractionPart = f;
    }

    /**
     * Constructs a mixed number with a given whole number part, numerator of the fraction part
     * and denominator of the fraction part.
     * <p>Example of usage: MixedFraction myFraction = new MixedFraction(8, 24, 36);</p>
     *
     * @param whole       This is the whole number value of the mixed fraction.
     * @param numerator   This is the numerator of the fraction.
     * @param denominator This is the denominator of the fraction.
     */
    public MixedNumber(int whole, int numerator, int denominator) {
        fractionPart = new Fraction(numerator, denominator);
        this.wholePart = whole;
    }

    /**
     * This getter method is used to get the value of the whole number field.
     * @return Returns the whole number value.
     */
    public int getWholePart() {
        return this.wholePart;
    }

    /**
     * This setter method is used to set the value of the whole number field.
     *
     * @param wholePart This is the whole number needed to set the its value.
     */
    public void setWholePart(int wholePart) {
        this.wholePart = wholePart;
    }

    /**
     * This setter method is used to set the values of the fraction part of a mixed fraction.
     *
     * @return Returns the fraction object that holds the value of the numerator and the denominator.
     */
    public Fraction getFractionPart() {
        return fractionPart;
    }

    /**
     * This setter method is used to set the values of the fraction part of a mixed fraction.
     *
     * @param fraction This is an object needed which holds the value of numerator and the denominator to set fraction part.
     */
    public void setFractionPart(Fraction fraction) {
        fractionPart = fraction;
    }

    public String toString() {
        String r = "";
        if (fractionPart.toDecimal() == 0) {
            r = wholePart + "";
        } else {
            r = (wholePart + " " + fractionPart.toString());
        }
        return r;
    }

    /**
     * This method converts mixed fraction into improper fraction.
     *
     * @return Returns an improper fraction equivalent to a mixed number.
     */
    public Fraction toFraction() {
        int num = fractionPart.getDenominator() * wholePart + fractionPart.getNumerator();
        int den = fractionPart.getDenominator();
        return new Fraction(num, den);
    }

    /**
     * This method is used to add fractions.
     * Algorithm
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. Add the two resulting fractions from steps "a" and "b"
     * d. Convert the result of step "c" to a mixed number form
     * e. Return the result of step "d"
     *
     * @param other This is the second fraction that will be added to the first fraction (the "this" fraction).
     * @return Returns the sum of the first fraction and the second fraction.
     */
    public MixedNumber add(MixedNumber other) {
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction sum = new Fraction(first.getNumerator() * second.getDenominator() + second.getDenominator() * first.getDenominator(), first.getDenominator() * second.getDenominator());
        MixedNumber result = sum.toMixedNumber();
        return result;
    }

    /**
     * This method is used to subtract fractions.
     * Algorithm
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. Subtract the two resulting fractions from steps "a" and "b"
     * d. Convert the result of step "c" to a mixed number form
     * e. Return the result of step "d"
     *
     * @param other This is the second fraction that will be subtracted to the first fraction (the "this" fraction).
     * @return Returns the difference of the first fraction and the second fraction.
     */
    public Fraction subtract(MixedNumber other) {
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction dif = new Fraction(first.getNumerator() * second.getDenominator() - second.getDenominator() * first.getDenominator(), first.getDenominator() * second.getDenominator());
        MixedNumber result = dif.toMixedNumber();
        return result;
    }

    /**
     * This method is used to multiply fractions.
     * Algorithm
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. Multiply the two resulting fractions from steps "a" and "b"
     * d. Convert the result of step "c" to a mixed number form
     * e. Return the result of step "d"
     *
     * @param other This is the second fraction that will be multiplied to the first fraction (the "this" fraction).
     * @return Returns the product of the first fraction and the second fraction.
     */
    public Fraction multiplyBy(MixedNumber other) {
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction p = new Fraction(first.getNumerator() * second.getNumerator(), first.getDenominator() * second.getDenominator());
        MixedNumber result = p.toMixedNumber();
        return result;
    }

    /**
     * This method is used to divide fractions.
     * Algorithm
     * a. Convert this mixed number to an equivalent improper fraction
     * b. Convert the other mixed number to and equivalent improper fraction
     * c. Divide the two resulting fractions from steps "a" and "b"
     * d. Convert the result of step "c" to a mixed number form
     * e. Return the result of step "d"
     *
     * @param other This is the second fraction that will be divided to the first fraction (the "this" fraction).
     * @return Returns the quotient of the first fraction and the second fraction.
     */
    public Fraction divideBy(MixedNumber other) {
        Fraction first = this.toFraction();
        Fraction second = other.toFraction();
        Fraction q = new Fraction(first.getNumerator() * second.getDenominator(), first.getDenominator() * second.getNumerator());
        MixedNumber result = q.toMixedNumber();
        return result;
    }

    /**
     * Returns true if this Mixed Number has the same
     * decimal value as another mixed number
     */
    public boolean equals(MixedNumber another) {
        return (this.toDecimal() == another.toDecimal());
    }

    /**
     * Returns the decimal value of this mixed number
     */
    public double toDecimal() {
        return (wholePart + 1.0 * fractionPart.getNumerator()/fractionPart.getDenominator());
    }
}
