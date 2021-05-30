/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

/**
 *
 * @author omarz
 */
public class Pyramid {

    String pharaoh, modernName, site;
    double height;

    public Pyramid(String pharaoh, String modernName, String site, String height) {
        super();
        this.pharaoh = pharaoh;
        this.modernName = modernName;
        this.site = site;
        try {
            this.height = Double.valueOf(height);
        } catch (Exception e) {
            this.height = -1;
        }
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getModernName() {
        return modernName;
    }

    public void setModernName(String modernName) {
        this.modernName = modernName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pyramid [pharaoh=" + pharaoh + ", modernName=" + modernName + ", site=" + site + ", height=" + height
                + "]";
    }
}
