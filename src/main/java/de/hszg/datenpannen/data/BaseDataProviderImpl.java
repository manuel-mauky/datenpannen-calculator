package de.hszg.datenpannen.data;

import de.hszg.datenpannen.model.InfluencingFactor;
import de.hszg.datenpannen.model.Sector;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class BaseDataProviderImpl implements BaseDataProvider {

    private Map<Sector, Double> lossCostPerSector = new HashMap<>();
    private Map<InfluencingFactor, Double> factorValues = new HashMap<>();

    public BaseDataProviderImpl() {
        initLossCostPerSector();
        initFactorValues();
    }

    private void initLossCostPerSector() {
        lossCostPerSector.put(Sector.COMMUNICATIONS, 119.0);
        lossCostPerSector.put(Sector.CONSUMER, 161.0);
        lossCostPerSector.put(Sector.ENERGY, 201.0);
        lossCostPerSector.put(Sector.FINANCIAL, 217.0);
        lossCostPerSector.put(Sector.HOSPITALITY, 141.0);
        lossCostPerSector.put(Sector.INDUSTRIAL, 214.0);
        lossCostPerSector.put(Sector.PHARMACEUTICAL, 114.0);
        lossCostPerSector.put(Sector.PUBLIC_SECTOR, 93.0);
        lossCostPerSector.put(Sector.RETAIL, 126.0);
        lossCostPerSector.put(Sector.SERVICES, 134.0);
        lossCostPerSector.put(Sector.TECHNOLOGY, 120.0);
    }

    private void initFactorValues() {
        factorValues.put(InfluencingFactor.CISO_APPOINTMENT, -5.0);
        factorValues.put(InfluencingFactor.CONSULTANTS_ENGAGED, -4.0);
        factorValues.put(InfluencingFactor.INCIDENT_MANAGEMENT_PLAN, -9.0);
        factorValues.put(InfluencingFactor.LOST_OR_STOLEN_DEVICES, 8.0);
        factorValues.put(InfluencingFactor.QUICK_NOTIFICATION, 6.0);
        factorValues.put(InfluencingFactor.STRONG_SECURITY_POSTURE, -11.0);
        factorValues.put(InfluencingFactor.THIRD_PARTY_ERROR, 12.0);
    }

    @Override
    public double getMinLossCost() {
        return 80.0;
    }

    @Override
    public double getMaxLossCost() {
        return 250.0;
    }

    @Override
    public double getAvgLossCost() {
        return 151.0;
    }

    @Override
    public double getValueOf(InfluencingFactor factor) {
        Double value = factorValues.get(factor);
        if (value == null) {
            return Double.NaN;
        } else {
            return value;
        }
    }

    @Override
    public double getLossCostOf(Sector sector) {
        Double value = lossCostPerSector.get(sector);
        if (value == null) {
            return Double.NaN;
        } else {
            return value;
        }
    }
}
