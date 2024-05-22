package com.example.streamingappbackend;

import com.example.streamingappbackend.api.Api;
import com.example.streamingappbackend.dao.GuestRepo;
import com.example.streamingappbackend.dao.MovieRepo;
import com.example.streamingappbackend.dao.RoleRepo;
import com.example.streamingappbackend.entity.Guest;
import com.example.streamingappbackend.entity.Movie;
import com.example.streamingappbackend.entity.Role;
import com.example.streamingappbackend.type.Category;
import com.example.streamingappbackend.type.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RequiredArgsConstructor
@CrossOrigin("*")
public class StreamingAppBackendApplication {

    private final MovieRepo movieRepo;
    private final PasswordEncoder passwordEncoder;
    private final GuestRepo guestRepo;
    private final RoleRepo roleRepo;
    private final Api api;



    @Bean @Profile("role")
    public ApplicationRunner runner3(){
        return r->{
            Role admin = new Role("ROLE_ADMIN");
            Role user  = new Role("ROLE_USER");

            roleRepo.save(admin);
            roleRepo.save(user);
        };
    }

    @Bean @ Profile("horror")
    public ApplicationRunner horror (){
        return r-> {
            Movie movie1 = new Movie("I Am legend",2007,"Francis Lawrence", Type.FREE, Category.HORROR,"/legend.jpg","Robert Neville,a scientist ,is the last human survivor of a plague in the whole of New York.He attempts to find a way to reverse the effects of the man-made virus by using his own immune blood.");
            Movie movie2 = new Movie("American Psycho",2000,"Mary Harron", Type.FREE, Category.HORROR,"/americanpsycho.jpg","Patrick Bateman,awealthy investment banker,hides his psychopatjic ego from his friends.Later,his illogical fantasies escalate and he submits to an uncomtrollable bloodlust");
            Movie movie3 = new Movie("Captive",2023,"Francis Lawrence", Type.PREMIUM, Category.HORROR,"/captive.jpg","Not content with scaring the removable skirts off of Eurovision.Finnish heavy metal monsters Lordi unleash some killer axe work upon a group of people trapped within the corridor of a hospital.");
            Movie movie4 = new Movie("Midsommar",2019,"Ari Aster", Type.PREMIUM, Category.HORROR,"/midsommar.jpg","Dani’s psychological trauma affects her realationship with Christian,her lover.However,when they visit their friend’s ancestral commune in an effort to mend things,it changes their lives forever.");
            Movie movie5 = new Movie("The Apostle",2014,"Cheyenne Carron", Type.FREE, Category.HORROR,"/apostle.jpg","A young Muslim man becomes touched by the love of jesus.");
            Movie movie6 = new Movie("The Scalper",2008,"Pete Riski", Type.FREE, Category.HORROR,"/scalper.jpg","Not content with scaring the removable skirts off of Eurovision.Finnish heavy metal monsters Lordi unleash some killer axe work upon a group of people trapped within the corridor of a hospital.");
            Movie movie7 = new Movie("Orphan",2009,"Francis Lawrence", Type.FREE, Category.HORROR,"/orphan.jpg","After losing their baby,a couple adopt a nine-year old girl.However,they soon make a troubling discovery about her mysterious past and uncover several traits of her disturbing persinality.");
            Movie movie8 = new Movie("Spring",2014,"Aaron Moorhead", Type.PREMIUM, Category.HORROR,"/spring.jpg","Evan,a ypung American,travels to Italy where he meets and has protected sex with Lousie,a flirtious girl.Thimgs take a turn when he goes to her house and witnesses something strange.");
            Movie movie9 = new Movie("Don't kill it",2016,"Francis Lawrence", Type.PREMIUM, Category.HORROR,"/dontkillit.jpg","Jebediah Woodley,a demon hunter ,accidentally realeases an invincible ancient devil.Trreafter,it spreads terror across the town and starts killing innocent people.");
            Movie movie10 = new Movie("The Mimic",2017,"Huh Jung", Type.PREMIUM, Category.HORROR,"/themimic.jpg","A couple that is reeling from the loss of their son adopts a young girl who lives near Mt Jang,which reputedly hosts a mythical creature.However,there is more to the child than what meets the eye.");


            movieRepo.save(movie1);
            movieRepo.save(movie2);
            movieRepo.save(movie3);
            movieRepo.save(movie4);
            movieRepo.save(movie5);
            movieRepo.save(movie6);
            movieRepo.save(movie7);
            movieRepo.save(movie8);
            movieRepo.save(movie9);
            movieRepo.save(movie10);

        };
    }

    @Bean @Profile("action")
    public ApplicationRunner action (){
        return r-> {
            Movie movie1 = new Movie("Baby Driver",2017,"Edgar Wright",Type.PREMIUM,Category.ACTION,"/babydriver.jpg","Doc forces baby, a farmer getaway driver,to partake in a heist,threatening to hurt his girlfriend if he refuses.But the plan goes away when their arms dealers turn out to be undercover officers.");
            Movie movie2= new Movie(" Drive",2011,"Nicolas Winding Refn",Type.FREE,Category.ACTION,"/drive.jpg","A stuntman and getaway driver falls in love with Irene who is married to a criminal.In a bid to protect her from her husband and some gangsters,he decides to cross over to the other sides of the law.");
            Movie movie3 = new Movie("Seven",1995,"David Fincher",Type.FREE,Category.ACTION,"/seven.jpg","Detectives Somerest and Mills,one a seasoned cop,the other relatively new one,are paired up to solve murders. Together they attempt to find a killer who us inspired by the seven deadly sins.");
            Movie movie4 = new Movie("What Happened to Monday",2017,"Tommy Wirkola",Type.FREE,Category.ACTION,"/whathappenedtomonday.jpg","In a world where oveon has compelled governments to adopt the one child policy,a set of identical set up lets live a hide-and-seek knife while searching for their missing sister.");
            Movie movie5 = new Movie("Inception ",2010,"Christopher Nolan",Type.FREE,Category.ACTION,"/inception.jpg","Cobb steals information from his targets by entering their dreams.He is wanted for his alleged role in his wife's murder and his only chance at redemption is to perform a nearly impossible task.");
            Movie movie6 = new Movie("Prisoners ",2013,"Denis Villeneuve",Type.FREE,Category.ACTION,"/prisoners.jpg","When the police take time to find Keller Dover's daughter and her friend, he decides to do on a search himself. His desperation leads him closer to finding the truth and else jeopardises his own life.");
            Movie movie7 = new Movie("The Batman",2022,"Matt Reeves",Type.PREMIUM,Category.ACTION,"/thebatman.jpg","Batman is called to intervene when the mayor of Gotham city is murdered. Soon, his investigation leads him to uncover a web of corruption, linked to his own dark past.");
            Movie movie8 = new Movie("Jurassic World Dominion",2022,"Colin Trevorroe",Type.PREMIUM,Category.ACTION,"/jurassicworlddominion.jpg","Four years after the destruction of Isla Nublar, dinosaur now live and hunt alongside humans all over the world.For all,whether human beings are to remain the apex predator on a planet they now share with history's most fearsome creatures. ");
            Movie movie9 = new Movie("Jurassic World:Fallen Kingdom ",2018,"Jeff Goldblum",Type.PREMIUM,Category.ACTION,"/jurassicworldfallenkingdom.jpg","After a volcano revolution proves to be a threat for the dinosaur, Owen and Clarie reach the defunct Jurassic World, a theme park,to save the animals from extinction. ");
            Movie movie10 = new Movie("As Good As Dead",2022,"R.Ellis Frazier",Type.PREMIUM,Category.ACTION,"/asgoodasdead.jpg","Bryant friend a troubled teen and introduce him to material arts.As Bryant mysterious and dangerous past catches up to him,he is forced into a life and dead struggle to clear his name,save the boy and get back all he left behind. ");

            movieRepo.save(movie1);
            movieRepo.save(movie2);
            movieRepo.save(movie3);
            movieRepo.save(movie4);
            movieRepo.save(movie5);
            movieRepo.save(movie6);
            movieRepo.save(movie7);
            movieRepo.save(movie8);
            movieRepo.save(movie9);
            movieRepo.save(movie10);

        };
    }

    @Bean @Profile("thriller")
    public ApplicationRunner thriller (){
        return r-> {
            Movie movie1 = new Movie("No Way Up",2024,"Claudio Fah",Type.PREMIUM,Category.THRILLER,"/nowayup.jpg","Trapped underwater when their plane crashes into the ocean,survivors must find a way to escape as ahsrks start to circle the wreckage.‍");
            Movie movie2 = new Movie("Blood Diamond",2006,"Edward Zwick",Type.FREE,Category.THRILLER,"/blooddiamond.jpg","Solomon is a abducted and forced to work in diamond mines,where he finds a priceless diamond and hides it.When Danny learns of it,he promises to help him find his family in exchange for the diamond.‍");
            Movie movie3 = new Movie("Confidential Informant",2023,"Mochael Oblowitz",Type.PREMIUM,Category.THRILLER,"/confidentialinformant.jpg","Two cops fall under the scrutiny of a suspicious internal affairs agent when one involves an informamt in a deadly scheme.‍");
            Movie movie4 = new Movie("Sanctified",2022,"Daniel Bielinski",Type.PREMIUM,Category.THRILLER,"/sanctified.jpg","An outlaw is rescued from death by a nun who is traveling through 1890 North Dakita.She nurses him back to health in excahange for him guiding her to a Church deep in the Badlands.‍");
            Movie movie5 = new Movie("Security",2017,"Alain DesRochers",Type.PREMIUM,Category.THRILLER,"/security.jpg","Eddie,a former marine captain who works as a security guard in a mall,must protect Hamie,an eleven-year-old-girl,from a gang that wants to kill her.‍");
            Movie movie6 = new Movie("End Of Watch",2012,"David Ayer",Type.FREE,Category.THRILLER,"/endofwatch.jpg","Two friends,Brian Taylor and Mike Zavala,are partners in the LA polic department.A gang leader wants them dead after they successfully arrest a few criminals.‍");
            Movie movie7 = new Movie("The Raven",2012,"James McTeigue",Type.FREE,Category.THRILLER,"/theraven.jpg","Poet and author Edger Allan Poe is questioned when a serial killer begins commiting gruesome murders that seem to be inspired by his srories.Things take a turn when Poe’s lover becomes a target.‍");
            Movie movie8 = new Movie("Black Swam",2010,"Darren Aronofsky",Type.FREE,Category.THRILLER,"/blackswam.jpg","Nina,a ballerins,gets the chance to play the White Swan,Princess Odette.But she finds herself slipping into madness when Thomas,the artistic director,decides that Lily might fit the role better‍.");
            Movie movie9 = new Movie("Bullitt",1968,"Peter Yates",Type.FREE,Category.THRILLER,"/bullitt.jpg","When mobsters kill the witness he wa assigned to protect,Bullitt,the dedicated policeman investigates the case on his own.However,the case soon takes an interesting turn.‍");
            Movie movie10 = new Movie("Exist Within",2024,"Kim Jeong Wook",Type.PREMIUM,Category.THRILLER,"/existwithin.jpg","A dull,again and again that dull thud is heard.The noise between room 401 and 501 has already started.");

            movieRepo.save(movie1);
            movieRepo.save(movie2);
            movieRepo.save(movie3);
            movieRepo.save(movie4);
            movieRepo.save(movie5);
            movieRepo.save(movie6);
            movieRepo.save(movie7);
            movieRepo.save(movie8);
            movieRepo.save(movie9);
            movieRepo.save(movie10);

        };
    }

    @Bean @Profile("comedy")
    public ApplicationRunner comedy (){
        return r-> {
            Movie movie1 = new Movie("The Wolf of Wall Street", 2013, "Scorsese", Type.FREE, Category.COMEDY, "/thewolfofwallstreet.jpg", "Introduced to life in the fast lane through stockbroking, Jordan Belfort takes a hit after a Wall Street crash. He teams up with Donnie Azoff, cheating his way to the top as his relationships slide.");
            Movie movie2 = new Movie("The Half of It", 2020, "Alice Wu", Type.FREE, Category.COMEDY, "/thehalfofit.jpg", "A shy, straight-A Chinese-American student helps the school jock woo a girl whom they both secretly desire. They find themselves connecting and learn about the nature of love.");
            Movie movie3 = new Movie("Just Friends", 2005, "Roger Kumble", Type.FREE, Category.COMEDY, "/justfriends.jpg", "Chris, a man who is overweight, goes through a transformation and becomes successful in life. Soon, he comes across his high school crush and former best friend, Jamie, who rejected him years ago.");
            Movie movie4 = new Movie("Vacation", 2015, "John Hughes", Type.FREE, Category.COMEDY, "/vacation.jpg", "Rusty Griswold plans a cross-country road trip with his wife and two sons in a bid to revive the lost ties between them. However, their trip turns into a series of mishaps, leading to altercations.");
            Movie movie5 = new Movie("Flora & Ulysses", 2021, "Lena Khan", Type.FREE, Category.COMEDY, "/flora&ulysses.jpg", "An imaginative and creative 10-year-old cynic could never have predicted that her little squirrel would be reborn as a superhero with the uncanny knack for helping her and the lovable but broken people in her life.");
            Movie movie6 = new Movie("Players", 2024, "Trish Sie", Type.PREMIUM, Category.COMEDY, "/players.jpg", "New York sportswriter Mack devises successful hookup techniques with friend Adam and their crew, but when she unexpectedly falls head over heels for one of her targets, they all must learn what it takes to go from simply scoring to playing for keeps.");
            Movie movie7 = new Movie("Home Sweet Home Alone", 2021, "Scorsese", Type.PREMIUM, Category.COMEDY, "/homesweethomealone.jpg", "A married couple tries to steal back a valuable heirloom from a troublesome 10-year-old kid while his parents are away.");
            Movie movie8 = new Movie("The Con-heartist", 2020, "Mez Tharatorn", Type.PREMIUM, Category.COMEDY, "/thecon-heartist.jpg", "Ina, whose ex-boyfriend runs off leaving her in debt, manages to catch a cunning con artist who tries to con her. Instead of turning him to the police, she hires this con artist to swindle her ex-boyfriend to get revenge.");
            Movie movie9 = new Movie("Clifford the Big Dog", 2021, "Walt Becker", Type.PREMIUM, Category.COMEDY, "/cliffordthebigdog.jpg", "Emily Elizabeth’s life turns interesting when a magical animal rescuer gifts her a cute red puppy, which grows to be a ten-foot-tall dog.");
            Movie movie10 = new Movie("The Kissing Booth 3", 2021, "Vince Marcello", Type.PREMIUM, Category.COMEDY, "/thekissingbooth3.jpg", "Determined to make the most of her final summer before college, Elle plans the ultimate bucket list as she navigates what comes next with Noah and Lee.");

            movieRepo.save(movie1);
            movieRepo.save(movie2);
            movieRepo.save(movie3);
            movieRepo.save(movie4);
            movieRepo.save(movie5);
            movieRepo.save(movie6);
            movieRepo.save(movie7);
            movieRepo.save(movie8);
            movieRepo.save(movie9);
            movieRepo.save(movie10);

        };
    }

    @Bean @Profile("romance")
    public ApplicationRunner romance (){
        return r-> {
            Movie movie1=new Movie("Midnight Sun",2018,"Scott Spear",Type.FREE,Category.ROMANCE,"/midnightsun.jpg", "A tennager,who suffers from sunlight sensitivity ,falls in love with a boy.Just when she starts living her dreams,her conditiond start worsening and keeping it a secrept becomes that much harder");
            Movie movie2=new Movie("Warm Bodies",2019,"Jonathan Levine",Type.FREE,Category.ROMANCE,"/warmbodies.jpg", "R,a zombie,saves Julie,a human, and develops feelings for her and their love is challenged because of their differences.Things take an unsual turn when R and other Zombies regain human qualities");
            Movie movie3=new Movie("Dear Nathan",2017,"Indra Gunawan", Type.FREE,Category.ROMANCE,"/dearnathan.jpg", "Salma,a transfer studrnd,becomes the talk os the school because a notorious student named Nathan chases after her loveSge tries to avoid him but ends up letting her guards down.");
            Movie movie4=new Movie("Me Before You",2016,"Thea Sharrock", Type.FREE,Category.ROMANCE,"/mebeforeyou.jpg", "	Lousia Clark accepts the job of being a caretaker of Will Traynor,a rigid man who has paralysis.However,her life tansformsas the two,gradually,form a bond and later fall in love");
            Movie movie5=new Movie("Friend Zone",2019,"Chayanop Boonprakob", Type.PREMIUM,Category.ROMANCE,"/friendzone.jpg","	Friendship between two best friends goes through a difficultpkase when emotions come in the way of their companionship");
            Movie movie6=new Movie("ON Your Wedding Day",2018,"Lee Seok Geun", Type.FREE,Category.ROMANCE,"/onyourweddingday.jpg", "	When his former high school lover invites him to her wedding,HwangWoo Yeon’s feelings for his old flame come alive once again");
            Movie movie7=new Movie("My Fault",2023,"Domingo Gonzalez", Type.PREMIUM,Category.ROMANCE,"/myfault.jpg", "	Noah has to leave her town,boyfriend and friends behind and move into the mansion of her mother’s new rich husband.There she meets Nick,her new stepbrother.She soon discovers that,brhind the Image of amodel son,Nick is hiding somrthing");
            Movie movie8=new Movie("20th century girl",2022,"Bang Woo Ri", Type.PREMIUM,Category.ROMANCE,"/20thcenturygirl.jpg", "	A teen girl has her eyes set on a boy for her lovesick best friend.However,things become complicated when she fallsin love and is forced to choose between love and friendship");
            Movie movie9=new Movie("Tweleve Days",2023,"Oi Wah Lam", Type.PREMIUM,Category.ROMANCE,"/twelvedays.jpg", "	Twelve scenes of a tumultuous marriage,from its happybeginning to its harash end");
            Movie movie10=new Movie("Grown-ups",2022,"Takuya Kato", Type.PREMIUM,Category.ROMANCE,"/grownups.jpg", "	A young couple,namely an art student Yumi and acting club member Naoya,is in a pinch,They noticed that Yumi is unexpectedly pregnant,andthey don’t know what they will do in the future");

            movieRepo.save(movie1);
            movieRepo.save(movie2);
            movieRepo.save(movie3);
            movieRepo.save(movie4);
            movieRepo.save(movie5);
            movieRepo.save(movie6);
            movieRepo.save(movie7);
            movieRepo.save(movie8);
            movieRepo.save(movie9);
            movieRepo.save(movie10);

        };
    }

//    @Bean @Profile("guest")
//    public ApplicationRunner runner2(){
//        return r->{
//            Guest guest1 = new Guest("Thiha","thiha@gmail.com",passwordEncoder.encode("Thiha"));
//            Guest guest2 = new Guest("Lynn","lynn@gmail.com",passwordEncoder.encode("lynn"));
//            guest1.setStatus(true);
//            guest2.setStatus(false);
//
//            var admin =roleRepo.findByRoleName("ROLE_ADMIN");
//            var user =roleRepo.findByRoleName("ROLE_USER");
//
//            admin.addGuest(guest1);
//            user.addGuest(guest2);
//
//            roleRepo.save(admin);
//            roleRepo.save(user);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(StreamingAppBackendApplication.class, args);
    }

}
