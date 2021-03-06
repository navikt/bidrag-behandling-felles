package no.nav.bidrag.behandling.felles.enums

import java.time.LocalDate
import java.util.Arrays

enum class InntektType(val beskrivelse: String, val belopstype: String, val gruppe: String, val maaVelges: Boolean, val forskudd: Boolean,
                       val bidrag: Boolean, val saertilskudd: Boolean, val bidragspliktig: Boolean, val bidragsmottaker: Boolean, val soknadsbarn: Boolean,
                       val gyldigFom: LocalDate, val gyldigTil: LocalDate) {

  INNTEKTSOPPLYSNINGER_ARBEIDSGIVER("Inntektsopplysninger fra arbeidsgiver", "AG", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  ALOYSE("Aløyse", "AL", "A",
    false, false, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  ATTFORING_AAP("Attføring/AAP", "AT", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  BARNETRYGD_MANUELL_VURDERING("Barnetrygd manuell vurdering", "BAMV", "",
    true, true, true, true, true, true, false, LocalDate.MIN, LocalDate.MAX),
  BARNS_SYKDOM("Barns sykdom", "BS", "",
    false, true, true, true, true, true, false, LocalDate.MIN, LocalDate.parse("2018-01-01")),
  OVERGANGSSTONAD("Overgangsstønad", "EFOS", "",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  EKSTRA_SMAABARNSTILLEGG("Ekstra småbarnstillegg", "ESBT", "BMA",
    true, true, true, true, false, true, false, LocalDate.MIN, LocalDate.MAX),
  MANGLENDE_BRUK_EVNE_SKJONN("Manglende bruk av evne (skjønn)", "EVNE", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  FOEDSEL_ADOPSJON("Fødsels- og adopsjonspenger", "FA", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  FORDEL_SAERFRADRAG_ENSLIG_FORSORGER("Fordel særfradrag enslig forsørger", "FSEF", "C",
    false, false, true, true, false, true, false, LocalDate.parse("2013-01-01"), LocalDate.MAX),
  LIGNINGSOPPLYSNINGER_MANGLER("Ingen ligningsopplysninger finnes", "ILOF", "",
    false, false, true, false, true, true, false, LocalDate.MIN, LocalDate.parse("2007-01-01")),
  NETTO_KAPITALINNTEKT("Netto kapitalinntekt", "KAP", "B",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.parse("2017-01-01")),
  KAPITALINNTEKT_SKE("Kapitalinntekt fra Skatteetaten", "KAPS", "B",
    false, true, true, true, true, true, true, LocalDate.parse("2015-01-01"), LocalDate.MAX),
  KAPITALINNTEKT_EGNE_OPPLYSNINGER("Kapitalinntekt egne opplysninger", "KIEO", "B",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  KONTANTSTOTTE("Kontantstøtte", "KONT", "BMB",
    true, true, true, true, false, true, false, LocalDate.MIN, LocalDate.MAX),
  SKATTEGRUNNLAG_KORRIGERT_BARNETILLEGG("Skattegrunnlag korrigert for barnetillegg", "LIGB", "A",
    false, true, false, false, false, true, false, LocalDate.parse("2013-01-01"), LocalDate.MAX),
  LIGNING_SKE("Ligning fra Skatteetaten", "LIGN", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.parse("2018-01-01")),
  SKATTEGRUNNLAG_SKE("Skattegrunnlag fra Skatteetaten", "LIGS", "A",
    false, true, true, true, true, true, true, LocalDate.parse("2015-01-01"), LocalDate.MAX),
  LONN_TREKK("Lønns- og trekkoppgave", "LTA", "A",
    false, true, true, true, true, true, true, LocalDate.parse("2015-01-01"), LocalDate.MAX),
  AINNTEKT_KORRIGERT_BARNETILLEGG("A-inntekt korrigert for barnetillegg", "LTAB", "",
    false, true, false, false, false, true, false, LocalDate.parse("2019-01-01"), LocalDate.MAX),
  LONN_SKE("Lønnsoppgave fra Skatteetaten", "LTR", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.parse("2016-01-01")),
  LONN_SKE_KORRIGERT_BARNETILLEGG("Lønnsoppgave fra Skatteetaten korrigert for barnetillegg", "LTRB", "A",
    false, true, true, false, false, true, false, LocalDate.parse("2014-01-01"), LocalDate.MAX),
  DOKUMENTASJON_MANGLER_SKJONN("Dokumentasjon mangler (skjønn)", "MDOK", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  PENSJON("Pensjon", "PE", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  PENSJON_KORRIGERT_BARNETILLEGG("Pensjon korrigert for barnetillegg", "PEB", "A",
    false, true, false, false, false, true, false, LocalDate.parse("2015-01-01"), LocalDate.parse("2016-01-01")),
  PERSONINNTEKT_EGNE_OPPLYSNINGER("Personinntekt egne opplysninger", "PIEO", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  REHABILITERINGSPENGER("Rehabiliteringspenger", "RP", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.parse("2013-01-01")),
  SAKSBEHANDLER_BEREGNET_INNTEKT("Saksbehandler beregnet inntekt", "SAK", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  SYKEPENGER("Sykepenger", "SP", "A",
    false, true, true, true, true, true, true, LocalDate.MIN, LocalDate.MAX),
  UTVIDET_BARNETRYGD("Utvidet barnetrygd", "UBAT", "BMC",
    true, true, true, true, false, true, false, LocalDate.MIN, LocalDate.MAX),
  FORDEL_SKATTEKLASSE2("Fordel skatteklasse 2", "FS2", "C",
    false, false, true, true, false, true, false, LocalDate.MIN, LocalDate.parse("2013-01-01"));

  companion object {
    fun getInntektTypeFromBelopstype(belopstype: String?): InntektType {
      return Arrays.stream(values()).filter { inntektType -> inntektType.belopstype == belopstype }.findFirst().orElse(
        INNTEKTSOPPLYSNINGER_ARBEIDSGIVER
      )
    }
  }

  object InntektTypeConstants {
    const val SKATTEGRUNNLAG_SKE: String = "SKATTEGRUNNLAG_SKE"
    const val KAPITALINNTEKT_SKE: String = "KAPITALINNTEKT_SKE"
    const val LONN_TREKK: String = "LONN_TREKK"
    const val AINNTEKT_KORRIGERT_BARNETILLEGG: String = "AINNTEKT_KORRIGERT_BARNETILLEGG"
  }
}
