package com.nsgrigorjev.bookservice.changelogs;

import com.nsgrigorjev.bookservice.model.Book;
import com.nsgrigorjev.bookservice.repository.BookRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ChangeUnit(id = "book_initializer", order = "001", author = "nsgrigorjev")
public class DatabaseChangeLog {
    private final BookRepository bookRepository;
    private final MongoTemplate mongoTemplate;

    @Execution
    public void changeSet(){
        List<Book> books = new ArrayList<>();
        books.add(Book.builder()
                .id("first")
                .title("«Унесенные ветром», Маргарет Митчелл")
                .description("Роман охватывает годы Гражданской войны в Соединенных Штатах Америки.")
                .imageLink("https://n1s1.hsmedia.ru/83/ec/e4/83ece4cdc42d933749857991e8968b6b/332x517_1_e28c063c3712602d51ff2e7574d4c34a@726x1131_0xac120003_10097618951571924285.jpg")
                .build());

        books.add(Book.builder()
                .id("second")
                .title("«Мастер и Маргарита», Михаил Булгаков")
                .description("Нетленная история о любви художника и героини, бесконечно преданной ему.")
                .imageLink("https://n1s1.hsmedia.ru/7b/27/60/7b27606f983fca4eeeff8981d105c870/332x525_1_f0e2ebc490d59eca418888784638c6a8@798x1263_0xac120003_2872116261571924272.jpg")
                .build());

        books.add(Book.builder()
                .id("third")
                .title("«Зеленая миля», Стивен Кинг")
                .description("Бывший надзиратель тюрьмы рассказывает историю из своей практики.")
                .imageLink("https://n1s1.hsmedia.ru/fb/92/e9/fb92e9483b937b29ff78289ada9a7162/332x488_1_e32b1307c0b232d98fbf3139c1142f10@726x1067_0xac120003_1709830691571925609.jpg")
                .build());

        books.add(Book.builder()
                .id("fourth")
                .title("«Шантарам», Грегори Дэвид Робертс")
                .description("Писатель создал роман по следам событий из собственной жизни.")
                .imageLink("https://n1s1.hsmedia.ru/68/9b/85/689b858b70382406248e0b9df0bfb58a/332x528_1_5b85bf0698379a7c7bbdefe4570b2899@468x744_0xac120003_3073148991571924326.jpg")
                .build());

        books.add(Book.builder()
                .id("fifth")
                .title("Монах, который продал свой «Феррари», Робин Шарма")
                .description("как найти свое призвание, подчинить судьбу и перестать бояться завтрашнего дня.")
                .imageLink("https://n1s1.hsmedia.ru/8c/d7/28/8cd7283ce3a3636a43b02391b745bfd8/332x512_1_7593881d1536a4e3d1b2f957c9e108e9@502x774_0xac120003_16240453471571924337.jpg")
                .build());

        books.add(Book.builder()
                .id("sixth")
                .title("«Грозовой перевал», Эмили Бронте")
                .description("История любви Хитклифа к Кэтрин, дочери своего хозяин.")
                .imageLink("https://n1s1.hsmedia.ru/cb/23/90/cb23906c589acec464a398e4592a1b66/332x513_1_7735befb67a4890c486d71c1cc49197d@726x1121_0xac120003_9799951311571924348.jpg")
                .build());

        books.add(Book.builder()
                .id("seventh")
                .title("«Двенадцать стульев», Илья Ильф и Евгений Петров")
                .description("Искрометный роман о приключениях Остапа Бендера и поиске бриллиантов оказался первым совместным творчеством писателей.")
                .imageLink("https://n1s1.hsmedia.ru/df/dd/f8/dfddf880ada32c5dc90e3278aae939a7/332x522_1_e4ec6774328032d9f76c89f81f54e696@726x1141_0xac120003_19629807261571925601.jpg")
                .build());

        books.add(Book.builder()
                .id("eighth")
                .title("«Портрет Дориана Грея», Оскар Уайльд")
                .description("Главный герой пожелал, чтобы вместо него старел портрет.")
                .imageLink("https://n1s1.hsmedia.ru/e9/e1/36/e9e136332593fc9e044dd1ff758f8979/332x502_1_7e226926fbb884e1fbf48a271f23e8c5@726x1097_0xac120003_11236507611571924476.jpg")
                .build());

        bookRepository.insert(books);
    }

    @RollbackExecution
    public void rollBack(){
        mongoTemplate.dropCollection("books");
    }

}
