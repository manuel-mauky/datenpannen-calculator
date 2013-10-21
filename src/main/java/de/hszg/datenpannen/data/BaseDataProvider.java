
package de.hszg.datenpannen.data;

import de.hszg.datenpannen.model.InfluencingFactor;
import de.hszg.datenpannen.model.Sector;

/**
 *
 * Schnittstelle für die Bereitstellung von Basisdaten. Wird vom BaseDataModel zum Laden der Basisdaten verwendet.
 */
public interface BaseDataProvider {
    
    public double getMinLossCost();
    
    public double getMaxLossCost();
    
    public double getAvgLossCost();
    
    public double getValueOf(InfluencingFactor factor);
    
    public double getLossCostOf(Sector sector);
    
}
