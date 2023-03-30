package no.nav.bidrag.behandling.felles.grunnlag.delberegning

import no.nav.bidrag.behandling.felles.grunnlag.IGrunnlagInnhold
import no.nav.bidrag.behandling.felles.grunnlag.ISoknadsbarn
import java.math.BigDecimal
import java.time.LocalDate

class BPsAndelSaertilskudd(
    val soktBelop: BigDecimal,
    val beregnetBelop: BigDecimal,
    val barnMaksInntektBelop: BigDecimal,
    val fordelKlasseIIBelop: BigDecimal,
    val prosent: Double,
    val harFullBidragsevne: Boolean,
    override val soknadsbarnId: Int,
    grunnlagReferanseListe: List<String>,
    datoFom: LocalDate,
    datoTil: LocalDate?
) :
    Delberegning<BPsAndelSaertilskudd>(grunnlagReferanseListe, datoFom, datoTil), IGrunnlagInnhold, ISoknadsbarn {

    override fun isEqualTo(other: BPsAndelSaertilskudd): Boolean {
        return soktBelop == other.soktBelop && beregnetBelop == other.beregnetBelop && barnMaksInntektBelop == other.barnMaksInntektBelop &&
            fordelKlasseIIBelop == other.fordelKlasseIIBelop && prosent == other.prosent && harFullBidragsevne == other.harFullBidragsevne &&
            soknadsbarnId == other.soknadsbarnId
    }
}
