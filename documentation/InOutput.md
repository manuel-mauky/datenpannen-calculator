#Daten In- und Output beim Kostenkalkulationstool

##Input

###User Eingaben

- Anzahl Datensätze spinner/int

- Industriezweig {} radiobuttons

    - Financial 
    - Industrial 
    - Energy 
    - Consumer 
    - Hospitality 
    - Services 
    - Retail 
    - Technology 
    - Communications 
    - Pharmaceutical 
    - Public Sector

- sonstige Faktoren{} checkboxen

    - Third party error 
    - Lost or stolen devices 
    - Quick notification 
    - Consultants engaged 
    - CISO appointment 
    - incident management plan 
    - Strong security posture

###Input aus Statistiken

- Durchschnittliche Kosten pro Datensatz int

- min Kosten pro Datensatz int

- max Kosten pro Datensatz int

- Kennwerte für Faktoren / Industrie{} double

- Aufteilung der Kosten{} double

    - Investigations & forensics 
    - Lost customer business 
    - Audit and consulting services 
    - Outbound contact costs 
    - Legal services - compliance 
    - Customer acquisition cost 
    - Inbound contact costs 
    - Legal services – defense 
    - Free or discounted services 
    - Identity protection services 
    - Public relations/communications
    
##Outputs

- Linechart (Kosten(Datensätze), min(D), max(D))

- Piechart (Aufteilung der Kosten(Selektion line chart))