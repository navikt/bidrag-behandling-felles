package no.nav.bidrag.behandling.felles.grunnlag

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.bidrag.behandling.felles.enums.BostatusKode
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import no.nav.bidrag.behandling.felles.enums.InntektType
import no.nav.bidrag.behandling.felles.enums.Rolle
import no.nav.bidrag.behandling.felles.enums.SaerfradragKode
import no.nav.bidrag.behandling.felles.enums.SivilstandKode
import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.BPsAndelSaertilskudd
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.BPsAndelUnderholdskostnad
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Bidragsevne
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.MaksBidragPerBarn
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.MaksGrense25Inntekt
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.NettoBarnetilsyn
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Samvaersfradrag
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Tilleggsbidrag
import no.nav.bidrag.behandling.felles.grunnlag.delberegning.Underholdskostnad
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.IInntektGrunnlag
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.Inntekt
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.InntektBarn
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.InntektUtvidetBarnetrygd
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.Inntektgrunnlag
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.InntektgrunnlagPost
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.Skattegrunnlag
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.SkattegrunnlagPost
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class GrunnlagSerDesTest {

  private val objectMapper: ObjectMapper = ObjectMapper()

  init {
    objectMapper.registerModule(JavaTimeModule())
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    objectMapper.registerModule(KotlinModule.Builder().build())
  }

  @Test
  fun TestGrunnlagSerdes() {

    val barn = Barn(Rolle.SOKNADSBARN, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2022, Month.JANUARY, 31), 1)
    val barnetillegg = Barnetillegg(Rolle.BIDRAGSMOTTAKER, 1, BigDecimal.valueOf(1500), BigDecimal.valueOf(0.3), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val barnetilleggForsvaret = BarnetilleggForsvaret(true, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val barnetilsynMedStonad = BarnetilsynMedStonad(LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), 1, StonadType.BIDRAG.name, "tilsyn")
    val barnIHusstand = BarnIHusstand(1, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val bostatus = Bostatus(Rolle.SOKNADSBARN, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), BostatusKode.MED_FORELDRE, 1)
    val bostatusBP = BostatusBP(BostatusKode.ALENE, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val deltBosted = DeltBosted(1, false, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val faktiskUtgift = FaktiskUtgift(LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), 1, BigDecimal.valueOf(1234))
    val forpleiningUtgift = ForpleiningUtgift(LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), 1, BigDecimal.valueOf(4321))
    val gebyrfritak = Gebyrfritak(LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2022, Month.MARCH, 1), true, "kode", BigDecimal.valueOf(432), Rolle.BIDRAGSPLIKTIG)
    val lopendeBidrag = LopendeBidrag(1, BigDecimal.valueOf(1000), BigDecimal.valueOf(900), BigDecimal.valueOf(800),LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val nettoSaertilskudd = NettoSaertilskudd(BigDecimal.valueOf(1200), 1, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val saerfradrag = Saerfradrag(SaerfradragKode.INGEN, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val samvaersklasse = Samvaersklasse(1, "01", "beskrivelse", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val sivilstand = Sivilstand(Rolle.BIDRAGSPLIKTIG, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), SivilstandKode.ENSLIG, "beskrivelse")
    val sjablon = Sjablon("navn", "verdi", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val skatteklasse = Skatteklasse(1, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val soknadsbarnInfo = SoknadsbarnInfo(1, LocalDate.of(2020, Month.JANUARY, 25),"12345678910")
    val soknadInfo = SoknadInfo(LocalDate.of(2020, Month.JANUARY, 25))

    val inntekterInntektgrunnlag = listOf(Inntektgrunnlag("12345678910", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), true, LocalDateTime.now(), null, LocalDateTime.now(), listOf(
      InntektgrunnlagPost("periode", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), "", "", "", "", "", BigDecimal.valueOf(25000), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    )))
    val inntekterSkattegrunnlag = listOf(Skattegrunnlag("12345678910", 2022, listOf(SkattegrunnlagPost(InntektType.SKATTEGRUNNLAG_SKE.name, BigDecimal.valueOf(15000)))))

    val inntekt = Inntekt(Rolle.BIDRAGSPLIKTIG, InntektType.LONN_TREKK, BigDecimal.valueOf(600000), true, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), emptyList())
    val inntektBarn = InntektBarn(1, Rolle.SOKNADSBARN, InntektType.LONN_TREKK, BigDecimal.valueOf(600000), true, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), inntekterInntektgrunnlag)
    val inntektUtvidetBarnetrygd = InntektUtvidetBarnetrygd(false, Rolle.BIDRAGSPLIKTIG, InntektType.UTVIDET_BARNETRYGD, BigDecimal.valueOf(600000), true, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), inntekterInntektgrunnlag)
    val skatteInntekt = Inntekt(Rolle.BIDRAGSPLIKTIG, InntektType.SKATTEGRUNNLAG_SKE, BigDecimal.valueOf(600000), true, LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31), inntekterSkattegrunnlag)

    val bidragsevne = Bidragsevne(BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), 0, false, true, "beskrivelse", BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val bPsAndelSaertilskudd = BPsAndelSaertilskudd(BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), 50.0, 1, listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val bPsAndelUnderholdskostnad = BPsAndelUnderholdskostnad(1, BigDecimal.valueOf(5000), 50.0, false, listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val maksBidragPerBarn = MaksBidragPerBarn(BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), 1, listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val maksGrense25Inntekt = MaksGrense25Inntekt(BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), 1, listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val nettoBarnetilsyn = NettoBarnetilsyn(1, BigDecimal.valueOf(1000), listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val samvaersfradrag = Samvaersfradrag(1, BigDecimal.valueOf(1000), listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val tilleggsbidrag = Tilleggsbidrag(BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), false, 2, 1, listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))
    val underholdskostnad = Underholdskostnad(1, BigDecimal.valueOf(1000), BigDecimal.valueOf(1000), "alderKode", false, BigDecimal.valueOf(1000), listOf("referanse1", "referanse2"), LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(9999, Month.DECEMBER, 31))

    val grunnlagListe: MutableList<Grunnlag> = mutableListOf()
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BARN, barn))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BARNETILLEGG, barnetillegg))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BARNETILLEGG_FORSVARET, barnetilleggForsvaret))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BARNETILSYN_MED_STONAD, barnetilsynMedStonad))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BARN_I_HUSSTAND, barnIHusstand))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BOSTATUS, bostatus))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BOSTATUS_BP, bostatusBP))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.DELT_BOSTED, deltBosted))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.FAKTISK_UTGIFT, faktiskUtgift))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.FORPLEINING_UTGIFT, forpleiningUtgift))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.GEBYRFRITAK, gebyrfritak))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.LOPENDE_BIDRAG, lopendeBidrag))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.NETTO_SAERTILSKUDD, nettoSaertilskudd))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SAERFRADRAG, saerfradrag))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SAMVAERSKLASSE, samvaersklasse))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SIVILSTAND, sivilstand))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SJABLON, sjablon))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SKATTEKLASSE, skatteklasse))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SOKNADSBARN_INFO, soknadsbarnInfo))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.INNTEKT, inntekt))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.INNTEKT, skatteInntekt))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.INNTEKT_BARN, inntektBarn))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.INNTEKT_UTVIDET_BARNETRYGD, inntektUtvidetBarnetrygd))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BIDRAGSEVNE, bidragsevne))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BPS_ANDEL_SAERTILSKUDD, bPsAndelSaertilskudd))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.BPS_ANDEL_UNDERHOLDSKOSTNAD, bPsAndelUnderholdskostnad))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.MAKS_BIDRAG_PER_BARN, maksBidragPerBarn))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.MAKS_GRENSE_25_INNTEKT, maksGrense25Inntekt))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.NETTO_BARNETILSYN, nettoBarnetilsyn))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SAMVAERSFRADRAG, samvaersfradrag))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.TILLEGGSBIDRAG, tilleggsbidrag))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.UNDERHOLDSKOSTNAD, underholdskostnad))
    grunnlagListe.add(Grunnlag("Referanse", GrunnlagType.SOKNAD_INFO, soknadInfo))


    val grunnlagAsString = serialize(grunnlagListe)
    println(grunnlagAsString)
    assertNotEquals("", grunnlagAsString)

    val deserializedGrunnlag = deserialize(grunnlagAsString)
    assertTrue(deserializedGrunnlag.isNotEmpty())
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Barn}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Barnetillegg}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is BarnetilleggForsvaret}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is BarnetilsynMedStonad}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is BarnIHusstand}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Bostatus}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is BostatusBP}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is DeltBosted}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is FaktiskUtgift}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is ForpleiningUtgift}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Gebyrfritak}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is LopendeBidrag}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is NettoSaertilskudd}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Saerfradrag}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Samvaersklasse}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Sivilstand}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Sjablon}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Skatteklasse}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is SoknadsbarnInfo}.size)
    assertEquals(4, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Inntekt}.size)
    val inntektGrunnlag: List<IInntektGrunnlag>  = deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Inntekt }.flatMap { grunnlag ->  (grunnlag.innhold as Inntekt).inntekter}
    assertEquals(2, inntektGrunnlag.filter { inntektsgrunnlag ->  inntektsgrunnlag is Inntektgrunnlag}.size)
    assertEquals(1, inntektGrunnlag.filter { inntektsgrunnlag ->  inntektsgrunnlag is Skattegrunnlag}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Bidragsevne}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is BPsAndelSaertilskudd}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is BPsAndelUnderholdskostnad}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is MaksBidragPerBarn}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is MaksGrense25Inntekt}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is NettoBarnetilsyn}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Samvaersfradrag}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Tilleggsbidrag}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is Underholdskostnad}.size)
    assertEquals(1, deserializedGrunnlag.filter { grunnlag ->  grunnlag.innhold is SoknadInfo}.size)

  }

  private fun serialize(grunnlag: List<Grunnlag>): String {
    var grunnlagString = ""
    try {
      grunnlagString = objectMapper.writeValueAsString(grunnlag)
    } catch (e: JsonProcessingException) {
      println(e.message)
    }
    return grunnlagString
  }

  private fun deserialize(jsonString: String): List<Grunnlag> {
    var grunnlag: List<Grunnlag> = emptyList()
    try {
      grunnlag = objectMapper.readValue(jsonString)
    } catch (processingE: JsonProcessingException) {
      println(processingE.message)
    } catch (mappingE: JsonMappingException) {
      println(mappingE.message)
    }
    return grunnlag
  }
}