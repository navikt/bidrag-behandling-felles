package no.nav.bidrag.behandling.felles.grunnlag

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.BPsAndelSaertilskudd
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.BPsAndelUnderholdskostnad
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Bidragsevne
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.MaksBidragPerBarn
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.MaksGrense25Inntekt
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.NettoBarnetilsyn
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Samvaersfradrag
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Tilleggsbidrag
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Underholdskostnad
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.Inntekt
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.InntektBarn
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.InntektUtvidetBarnetrygd

class Grunnlag(
  val referanse: String,
  val type: GrunnlagType,
  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
  @JsonSubTypes(
    value = [
      JsonSubTypes.Type(value = Saerfradrag::class, name = GrunnlagType.GrunnlagTypeConstants.SAERFRADRAG),
      JsonSubTypes.Type(value = SoknadsbarnInfo::class, name = GrunnlagType.GrunnlagTypeConstants.SOKNADSBARN_INFO),
      JsonSubTypes.Type(value = Skatteklasse::class, name = GrunnlagType.GrunnlagTypeConstants.SKATTEKLASSE),
      JsonSubTypes.Type(value = BarnIHusstand::class, name = GrunnlagType.GrunnlagTypeConstants.BARN_I_HUSSTAND),
      JsonSubTypes.Type(value = Bostatus::class, name = GrunnlagType.GrunnlagTypeConstants.BOSTATUS),
      JsonSubTypes.Type(value = BostatusBP::class, name = GrunnlagType.GrunnlagTypeConstants.BOSTATUS_BP),
      JsonSubTypes.Type(value = Inntekt::class, name = GrunnlagType.GrunnlagTypeConstants.INNTEKT),
      JsonSubTypes.Type(value = NettoSaertilskudd::class, name = GrunnlagType.GrunnlagTypeConstants.NETTO_SAERTILSKUDD),
      JsonSubTypes.Type(value = Samvaersklasse::class, name = GrunnlagType.GrunnlagTypeConstants.SAMVAERSKLASSE),
      JsonSubTypes.Type(value = Bidragsevne::class, name = GrunnlagType.GrunnlagTypeConstants.BIDRAGSEVNE),
      JsonSubTypes.Type(value = Samvaersfradrag::class, name = GrunnlagType.GrunnlagTypeConstants.SAMVAERSFRADRAG),
      JsonSubTypes.Type(value = Sjablon::class, name = GrunnlagType.GrunnlagTypeConstants.SJABLON),
      JsonSubTypes.Type(value = LopendeBidrag::class, name = GrunnlagType.GrunnlagTypeConstants.LOPENDE_BIDRAG),
      JsonSubTypes.Type(value = FaktiskUtgift::class, name = GrunnlagType.GrunnlagTypeConstants.FAKTISK_UTGIFT),
      JsonSubTypes.Type(value = BarnetilsynMedStonad::class, name = GrunnlagType.GrunnlagTypeConstants.BARNETILSYN_MED_STONAD),
      JsonSubTypes.Type(value = ForpleiningUtgift::class, name = GrunnlagType.GrunnlagTypeConstants.FORPLEINING_UTGIFT),
      JsonSubTypes.Type(value = Barn::class, name = GrunnlagType.GrunnlagTypeConstants.BARN),
      JsonSubTypes.Type(value = Sivilstand::class, name = GrunnlagType.GrunnlagTypeConstants.SIVILSTAND),
      JsonSubTypes.Type(value = Barnetillegg::class, name = GrunnlagType.GrunnlagTypeConstants.BARNETILLEGG),
      JsonSubTypes.Type(value = BarnetilleggForsvaret::class, name = GrunnlagType.GrunnlagTypeConstants.BARNETILLEGG_FORSVARET),
      JsonSubTypes.Type(value = DeltBosted::class, name = GrunnlagType.GrunnlagTypeConstants.DELT_BOSTED),
      JsonSubTypes.Type(value = NettoBarnetilsyn::class, name = GrunnlagType.GrunnlagTypeConstants.NETTO_BARNETILSYN),
      JsonSubTypes.Type(value = Underholdskostnad::class, name = GrunnlagType.GrunnlagTypeConstants.UNDERHOLDSKOSTNAD),
      JsonSubTypes.Type(value = BPsAndelUnderholdskostnad::class, name = GrunnlagType.GrunnlagTypeConstants.BPS_ANDEL_UNDERHOLDSKOSTNAD),
      JsonSubTypes.Type(value = Tilleggsbidrag::class, name = GrunnlagType.GrunnlagTypeConstants.TILLEGGSBIDRAG),
      JsonSubTypes.Type(value = MaksBidragPerBarn::class, name = GrunnlagType.GrunnlagTypeConstants.MAKS_BIDRAG_PER_BARN),
      JsonSubTypes.Type(value = BPsAndelSaertilskudd::class, name = GrunnlagType.GrunnlagTypeConstants.BPS_ANDEL_SAERTILSKUDD),
      JsonSubTypes.Type(value = MaksGrense25Inntekt::class, name = GrunnlagType.GrunnlagTypeConstants.MAKS_GRENSE_25_INNTEKT),
      JsonSubTypes.Type(value = Gebyrfritak::class, name = GrunnlagType.GrunnlagTypeConstants.GEBYRFRITAK),
      JsonSubTypes.Type(value = Inntekt::class, name = GrunnlagType.GrunnlagTypeConstants.INNTEKT),
      JsonSubTypes.Type(value = InntektBarn::class, name = GrunnlagType.GrunnlagTypeConstants.INNTEKT_BARN),
      JsonSubTypes.Type(value = InntektUtvidetBarnetrygd::class, name = GrunnlagType.GrunnlagTypeConstants.INNTEKT_UTVIDET_BARNETRYGD),
      JsonSubTypes.Type(value = SoknadInfo::class, name = GrunnlagType.GrunnlagTypeConstants.SOKNAD_INFO),
      JsonSubTypes.Type(value = BarnInfo::class, name = GrunnlagType.GrunnlagTypeConstants.BARN_INFO),
      JsonSubTypes.Type(value = PersonInfo::class, name = GrunnlagType.GrunnlagTypeConstants.PERSON_INFO),
      JsonSubTypes.Type(value = SaksbehandlerInfo::class, name = GrunnlagType.GrunnlagTypeConstants.SAKSBEHANDLER_INFO),
      JsonSubTypes.Type(value = VedtakInfo::class, name = GrunnlagType.GrunnlagTypeConstants.VEDTAK_INFO),
      JsonSubTypes.Type(value = InnbetaltBelop::class, name = GrunnlagType.GrunnlagTypeConstants.INNBETALT_BELOP)
    ]
  )
  val innhold: IGrunnlagInnhold) {}

