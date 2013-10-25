
package de.hszg.datenpannen.data;

import de.hszg.datenpannen.model.CostDistribution;
import de.hszg.datenpannen.model.InfluencingFactor;
import de.hszg.datenpannen.model.Sector;

import java.util.Map;

/**
 * Schnittstelle für die Bereitstellung von Basisdaten. Wird vom BaseDataModel zum Laden der Basisdaten verwendet.
 */
public interface BaseDataProvider {

    /**
     * Die Durchschnittlichen Min Kosten pro Datensatz. Dieser Wert in Kombination mit Max (siehe {@link
     * #getMaxLossCost()} und Avg {@link #getAvgLossCost()} wird benutzt um das Verhältnis auszurechnen, mit dem für
     * einzelne Industrie-Sektoren die Min-, Max- und Avg-Werte berechnet werden.
     */
    double getMinLossCost();

    /**
     * Siehe {@link #getMinLossCost()}.
     */
    double getMaxLossCost();

    /**
     * Siehe {@link #getMinLossCost()}.
     */
    double getAvgLossCost();

    double getValueOf(InfluencingFactor factor);


    int getLossCostOf(Sector sector);


    double getPercentageOf(CostDistribution distribution);

    /**
     * @return die Map der {@link InfluencingFactor} Werte.
     */
    Map<InfluencingFactor, Double> getInfluencingFactorMap();

    /**
     * @return die Map der {@link Sector} Werte.
     */
    Map<Sector, Integer> getSectorMap();

    /**
     * @return die Map der {@link CostDistribution} Werte.
     */
    Map<CostDistribution,Double> getCostDistributionMap();

}
