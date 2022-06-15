# bidrag-behandling-felles

![](https://github.com/navikt/bidrag-behandling-felles/workflows/maven%20deploy/badge.svg)

Inneholder enums/konstanter og funksjonalitet som er felles for flere repositories ifbm behandling av bidrag

## release endringer


| versjon | endringstype | beskrivelse                                                     |
|---------|--------------|-----------------------------------------------------------------|
| 0.0.1   | Opprettet    | Initiell versjon                                                |
| 0.0.2   | Endret       | Ingen endring. Test av opplasting til Nexus                     |
| 0.0.3   | Endret       | Lagt til GrunnlagType enum.                                     |
| 0.0.4   | Endret       | Lagt til VedtakType-enum.                                       |
| 0.0.5   | Endret       | Lagt til SivilstandKode-enum.                                   |
| 0.0.6   | Endret       | Lagt til SaerfradragKode og BostatusKode.                       |
| 0.0.7   | Endret       | Lagt til Sjablon-enums, AvvikType, InntektType og Rolle         |
| 0.0.8   | Endret       | Lagt til funksjon for å hente belopstype fra InntektType        |
| 0.0.9   | Endret       | Lagt til BOSTATUS_BP som GrunnlagType                           |
| 0.0.10  | Endret       | Lagt til diverse enums fra bidrag-grunnlag                      |
| 0.0.11  | Endret       | Lagt til enum EngangsbelopType for bidrag-vedtak                |                     
| 0.0.12  | Endret       | Lagt til Grunnlag-klasser                                       |
| 0.0.13  | Endret       | Feltene datoFom og datoTil er gjort mutable i Periode           |
| 0.0.14  | Endret       | Lagt til GrunnlagRequestType-enum.                              |
| 0.0.15  | Endret       | Rettet typo i BARNETILLEGG                                      |
| 0.0.16  | Endret       | brukTil i Inntektgrunnlag nullable.                             |
| 0.0.17  | Endret       | Lagt til GrunnlagRequestTyper for kall til bidrag-person -> PDL |
| 0.0.18  | Endret       | Rettet feil i enum                                              |
| 0.0.19  | Endret       | Utvidet EngangsbelopType-enum og justert SoknadsbarnInfo        |
| 0.0.20  | Endret       | Lagt til flere grunnlagRequestTyper                             |
| 0.0.21  | Endret       | Rettet Equals logikk i grunnlaget BarnetilsynMedStonad          |
| 0.0.22  | Endret       | Endret enkelte felter til nullable i InntektsgrunnlagPost       |
| 0.0.23  | Endret       | Utvidet equals-metode for sammenligning av inntekter            |
| 0.0.24  | Endret       | Gjort noen felter nullable i Gebyrfritak-objektet               |
| 0.0.25  | Endret       | GrunnlagReferanseListe endret fra val til var i Delberegning    |
| 0.0.26  | Endret       | Fjernet `soknadsbarnId` fra Sivilistand                         |
| 0.0.27  | Endret       | Lagt til Rolle interface                                        |
| 0.0.28  | Endret       | Gjort datoTil nullable                                          |
| 0.0.29  | Endret       | Fjernet SAERTILSKUDD fra StonadType                             |
| 0.0.30  | Endret       | Lagt til KONTANTSTOTTE som ny GrunnlagRequestType               |
| 0.0.31  | Endret       | Endret Rolle-enum til å inneholde 2 bokstaver (BP/BM/SB)        |
| 0.0.32  | Endret       | Justert litt på Rolle-enum                                      |
| 0.0.33  | Endret       | Ingen endringer, kun ny versjon                                 |