package agh.iisg.lab;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class UokikParserTest {
  private static Parser uokik;

  @BeforeClass
  public static void setUp() {
    uokik = new Parser(FileLoader.load("assets/uokik.txt"));
  }

  @Test
  public void articleCountTest() {
    List<Partition> articles = uokik.getLaw()
                                    .getPartitions()
                                    .stream()
                                    .flatMap(division -> division.getPartitions().stream())
                                    .flatMap(chapter -> chapter.getPartitions().stream())
                                    .flatMap(article -> article.getPartitions().stream()).collect(toList());

    assertEquals(
      177,
      articles.size()
    );

    assertEquals(
      "Art. 138.",
      articles.get(articles.size()).getTitle()
    );
  }

  @Test
  public void articleRangeTest() {
    assertEquals(
      "Art. 29.\n1. Prezes Urzędu jest centralnym organem administracji rządowej właściwym w sprawach ochrony konkurencji i konsumentów. Prezes Rady Ministrów sprawuje nadzór nad działalnością Prezesa Urzędu.\n2. Prezes Urzędu jest:\n1)Europejskiej na podstawie art. 104 i art. 105 TFUE. W szczególności Prezes\nUrzędu jest właściwym organem ochrony konkurencji w rozumieniu art. 35 rozporządzenia nr 1/2003/WE;\n2) jednolitym urzędem łącznikowym w rozumieniu przepisów rozporządzenia nr 2006/2004/WE oraz, w zakresie swoich ustawowych kompetencji, jest właściwym organem, o którym mowa w art. 4 ust. 1 rozporządzenia nr 2006/2004/WE.\n3. Prezes Rady Ministrów powołuje Prezesa Urzędu spośród osób wyłonionych w drodze otwartego i konkurencyjnego naboru.\n3a. Stanowisko Prezesa Urzędu może zajmować osoba, która:\n1) posiada tytuł zawodowy magistra lub równorzędny;\n2) jest obywatelem polskim;\n3) korzysta z pełni praw publicznych;\n4) nie była skazana prawomocnym wyrokiem za umyślne przestępstwo lub umyślne przestępstwo skarbowe;\n5) posiada kompetencje kierownicze;\n6) posiada co najmniej 6-letni staż pracy, w tym co najmniej 3-letni staż pracy na stanowisku kierowniczym;\n7) posiada wykształcenie i wiedzę z zakresu spraw należących do właściwości\nPrezesa Urzędu.\n3b. Informację o naborze na stanowisko Prezesa Urzędu ogłasza się przez umieszczenie ogłoszenia w miejscu powszechnie dostępnym w siedzibie Urzędu oraz w Biuletynie Informacji Publicznej Urzędu i Biuletynie Informacji Publicznej\nKancelarii Prezesa Rady Ministrów. Ogłoszenie powinno zawierać:\n1) nazwę i adres Urzędu;\n2) określenie stanowiska;\n3) wymagania związane ze stanowiskiem wynikające z przepisów prawa;\n4) zakres zadań wykonywanych na stanowisku;\n5) wskazanie wymaganych dokumentów;\n6) termin i miejsce składania dokumentów;\n7) informację o metodach i technikach naboru.\n3c. Termin, o którym mowa w ust. 3b pkt 6, nie może być krótszy niż 10 dni od dnia opublikowania ogłoszenia w Biuletynie Informacji Publicznej Kancelarii Prezesa\nRady Ministrów.\n3d. Nabór na stanowisko Prezesa Urzędu przeprowadza zespół, powołany przez\nSzefa Kancelarii Prezesa Rady Ministrów z upoważnienia Prezesa Rady Ministrów, liczący co najmniej 3 osoby, których wiedza i doświadczenie dają rękojmię wyłonienia najlepszych kandydatów. W toku naboru ocenia się doświadczenie zawodowe kandydata, wiedzę niezbędną do wykonywania zadań na stanowisku, na które jest przeprowadzany nabór, oraz kompetencje kierownicze.\n3e. Ocena wiedzy i kompetencji kierowniczych, o których mowa w ust. 3d, może być dokonana na zlecenie zespołu przez osobę niebędącą członkiem zespołu, która posiada odpowiednie kwalifikacje do dokonania tej oceny.\n3f. Członek zespołu oraz osoba, o której mowa w ust. 3e, mają obowiązek zachowania w tajemnicy informacji dotyczących osób ubiegających się o stanowisko, uzyskanych w trakcie naboru.\n3g. W toku naboru zespół wyłania nie więcej niż 3 kandydatów, których przedstawia Szefowi Kancelarii Prezesa Rady Ministrów.\n3h. Z przeprowadzonego naboru zespół sporządza protokół zawierający:\n1) nazwę i adres Urzędu;\n2) określenie stanowiska, na które był prowadzony nabór, oraz liczbę kandydatów;\n3) imiona, nazwiska i adresy nie więcej niż 3 najlepszych kandydatów uszeregowanych według poziomu spełniania przez nich wymagań określonych w ogłoszeniu o naborze;\n4) informację o zastosowanych metodach i technikach naboru;\n5) uzasadnienie dokonanego wyboru albo powody niewyłonienia kandydata;\n6) skład zespołu.\n3i. Wynik naboru ogłasza się niezwłocznie przez umieszczenie informacji w Biuletynie Informacji Publicznej Urzędu i Biuletynie Informacji Publicznej\nKancelarii Prezesa Rady Ministrów. Informacja o wyniku naboru zawiera:\n1) nazwę i adres Urzędu;\n2) określenie stanowiska, na które był prowadzony nabór;\n3) imiona, nazwiska wybranych kandydatów oraz ich miejsca zamieszkania w rozumieniu przepisów Kodeksu cywilnego albo informację o niewyłonieniu kandydata.\n3j. Umieszczenie w Biuletynie Informacji Publicznej Kancelarii Prezesa Rady\nMinistrów ogłoszenia o naborze oraz o wyniku tego naboru jest bezpłatne.\n4. Prezes Rady Ministrów odwołuje Prezesa Urzędu. Prezes Urzędu pełni obowiązki do dnia powołania jego następcy.\n5. (uchylony)\n6. Prezes Urzędu wykonuje swoje zadania przy pomocy Urzędu Ochrony\nKonkurencji i Konsumentów, zwanego dalej „Urzędem”.\n7. (uchylony)\n8. (uchylony)\nArt. 30.\n1. Prezes Rady Ministrów powołuje wiceprezesów Urzędu spośród osób wyłonionych w drodze otwartego i konkurencyjnego naboru. Prezes Rady Ministrów odwołuje wiceprezesów Urzędu na wniosek Prezesa Urzędu.\n2. Zespół przeprowadzający nabór na stanowiska, o których mowa w ust. 1, powołuje Prezes Urzędu.\n3. Do sposobu przeprowadzania naboru na stanowiska, o których mowa w ust. 1, stosuje się odpowiednio przepisy art. 29 ust. 3a–3j.\nArt. 31.\nDo zakresu działania Prezesa Urzędu należy:\n1) sprawowanie kontroli przestrzegania przez przedsiębiorców przepisów ustawy;\n2) wydawanie decyzji w sprawach praktyk ograniczających konkurencję, w sprawach koncentracji przedsiębiorców, w sprawach o uznanie postanowień wzorca umowy za niedozwolone oraz w sprawach praktyk naruszających zbiorowe interesy konsumentów, a także innych decyzji przewidzianych w ustawie;\n3) prowadzenie badań stanu koncentracji gospodarki oraz zachowań rynkowych przedsiębiorców;\n4) przygotowywanie projektów rządowych programów rozwoju konkurencji oraz projektów rządowej polityki konsumenckiej;\n5) współpraca z krajowymi i międzynarodowymi organami i organizacjami, do których zakresu działania należy ochrona konkurencji i konsumentów;\n6) wykonywanie zadań i kompetencji organu ochrony konkurencji państwa członkowskiego Unii Europejskiej, określonych w rozporządzeniu nr 1/2003/WE oraz w rozporządzeniu nr 139/2004/WE;\n7) wykonywanie zadań i kompetencji właściwego organu oraz jednolitego urzędu łącznikowego państwa członkowskiego Unii Europejskiej, określonych w rozporządzeniu nr 2006/2004/WE;\n7a) wykonywanie zadań określonych w ustawie z dnia 23 września 2016 r. o pozasądowym rozwiązywaniu sporów konsumenckich (Dz. U. poz. 1823);\n8) opracowywanie i przedkładanie Radzie Ministrów projektów aktów prawnych dotyczących ochrony konkurencji i konsumentów;\n9) przedkładanie Radzie Ministrów okresowych sprawozdań z realizacji rządowych programów rozwoju konkurencji i polityki konsumenckiej;\n10) współpraca z organami samorządu terytorialnego, w zakresie wynikającym z rządowej polityki konsumenckiej;\n11) (uchylony)\n12) opracowywanie i wydawanie publikacji oraz programów edukacyjnych popularyzujących wiedzę o ochronie konkurencji i konsumentów;\n13) występowanie do przedsiębiorców w sprawach z zakresu ochrony konkurencji i konsumentów;\n14) realizacja zobowiązań międzynarodowych Rzeczypospolitej Polskiej w zakresie współpracy i wymiany informacji w sprawach ochrony konkurencji i konsumentów oraz pomocy publicznej;\n15) gromadzenie i upowszechnianie orzecznictwa w sprawach z zakresu ochrony konkurencji i konsumentów, w szczególności przez zamieszczanie decyzji\nPrezesa Urzędu na stronie internetowej Urzędu;\n16) współpraca z Szefem Krajowego Centrum Informacji Kryminalnych w zakresie niezbędnym do realizacji jego zadań ustawowych;\n16a) współpraca z Agencją do spraw Współpracy Organów Regulacji Energetyki, z organem właściwym do spraw regulacji gospodarki paliwami i energią oraz organem właściwym w sprawach nadzoru nad rynkiem finansowym, w zakresie niezbędnym do wykonywania obowiązków wynikających z rozporządzenia\nParlamentu Europejskiego i Rady (UE) nr 1227/2011 z dnia 25 października 2011 r. w sprawie integralności i przejrzystości hurtowego rynku energii (Dz.\nUrz. UE L 326 z 08.12.2011, str. 1);\n16b) współpraca z Komisją Nadzoru Audytowego, w tym udzielanie informacji, wyjaśnień i przekazywanie dokumentów, w zakresie niezbędnym do realizacji zadań związanych z monitorowaniem rynku w zakresie, o którym mowa w art. 27 rozporządzenia Parlamentu Europejskiego i Rady (UE) nr 537/2014 z dnia 16 kwietnia 2014 r. w sprawie szczegółowych wymogów dotyczących ustawowych badań sprawozdań finansowych jednostek interesu publicznego, uchylającego decyzję Komisji 2005/909/WE (Dz. Urz. UE L 158 z 27.05.2014, str. 77 oraz Dz. Urz. UE L 170 z 11.06.2014, str. 66);\n17) wykonywanie innych zadań określonych w ustawie lub ustawach odrębnych.\nArt. 31a.\nPrezes Urzędu może wydać i ogłosić wyjaśnienia i interpretacje mające istotne znaczenie dla stosowania przepisów w sprawach objętych zakresem działania Prezesa Urzędu. Wyjaśnienia i interpretacje są publikowane w Biuletynie\nInformacji Publicznej Urzędu.\nArt. 31b.\nPrezes Urzędu publikuje na stronie internetowej Urzędu w całości treść decyzji wydawanych na podstawie przepisów ustawy, z zastrzeżeniem, że publikacja uzasadnienia nie obejmuje tajemnicy przedsiębiorstwa, jak również innych informacji podlegających ochronie na podstawie odrębnych przepisów. Publikacja opatrzona jest informacją, czy decyzja jest prawomocna.\nArt. 31c.\nPrezes Urzędu może nieodpłatnie publikować w publicznej radiofonii i telewizji, w formie i czasie uzgodnionymi z właściwą jednostką publicznej radiofonii i telewizji:\n1) komunikaty dotyczące zachowań lub zjawisk mogących stanowić istotne zagrożenie dla interesów konsumentów;\n2) informacje, co do których zostało wydane postanowienie, o którym mowa w art. 73a ust. 2.\nArt. 31d.\nPrezes Urzędu, jeżeli uzna że przemawia za tym interes publiczny, przedstawia sądowi istotny dla sprawy pogląd w sprawach dotyczących ochrony konkurencji i konsumentów.\nArt. 32.\n(uchylony)\n",
      uokik.getArticleRange("29", "32")
           .stream()
           .map(article -> article.getTitle() + "\n" + article.getContent() + "\n")
           .reduce("", String::concat)
    );
  }

  @Test
  public void getLetterTest() {
    assertEquals(
      "zasad organizacji i zarządzania – co do których podjęto działania zmierzające do zapobieżenia ich ujawnieniu, jeżeli skutkiem tych umów jest nieuzasadnione ograniczenie swobody działalności gospodarczej stron lub istotne ograniczenie konkurencji na rynku.",
      uokik.getArticle("2").getPartition("2").getPartition("2").getPartition("b)").getContent()
    );
  }
}
