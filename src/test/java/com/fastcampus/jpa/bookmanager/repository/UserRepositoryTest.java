package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){ //create, read, update, delete

        /*
        userRepository.save(new Users());
        userRepository.findAll().forEach(it->{
            System.out.println(">>> " + it.toString());
        });
         */
        /*
        userRepository.findAll().forEach(System.out::println);
         */

        /*
        List<Users> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        users.forEach(System.out::println);
        */
        /*
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(3L);
        ids.add(5L);
         */
        /*
        List<Long> ids = Lists.newArrayList(1L,3L,5L);
        users = userRepository.findAllById(ids);
        users.forEach(System.out::println);
        Users user1 = new Users(null,"jack","jack@fastcampus.com", LocalDateTime.now(),LocalDateTime.now());

        userRepository.save(user1);
        users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        users.forEach(System.out::println);
        */
        /*
        Users user = userRepository.getOne(1L);
        //lazy 로딩을 지원하는 getOne은 호출하는 함수에
        //Transactional을 꼭 붙여줘야 한다. @Transactional
        //지연 로딩을 하려면 해당 객체는 무조건 영속성 컨텍스트에서 관리해야 한다.
        System.out.println(user);
        */
        /*
        Optional<Users> user = userRepository.findById(1L);
        //user.orElse(null) >> Users를 리턴
        //user.get() >> Users를 리턴
        System.out.println(user.orElse(null));
        */

        /*
        userRepository.save(new Users("new martin","newmartin@fastcampus.com"));
        userRepository.flush();

        userRepository.findAll().forEach(System.out::println);

         */

        /*
        userRepository.saveAndFlush(new Users("new martin","newmartin@fastcampus.com"));
        userRepository.findAll().forEach(System.out::println);
         */

        /*
        long count = userRepository.count();
        System.out.println(count);
        */

        /*
        boolean exists = userRepository.existsById(1L);
        System.out.println(exists);
         */

        //userRepository.delete(userRepository.findById(1L).orElse(null));
        //userRepository.delete(userRepository.findById(1L).orElseThrow(()-> new RuntimeException()));
        //userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        //userRepository.deleteById(1L);

        //밑에 처럼 지우면 delete때 하나 하나 loop를 돌게 된다.
        //userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        //userRepository.findAll().forEach(System.out::println);

        //밑에 처럼 지우면 지울 때 or사용 근데 Deprecated 됨 >>deleteAllInBatch 대체
        //userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        //userRepository.findAll().forEach(System.out::println);

        //delete할 때 select과정을 없애버린거다.
        //userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        //userRepository.findAll().forEach(System.out::println);

        /*
        Page<Users> users = userRepository.findAll(PageRequest.of(1,3));
        System.out.println(users.getTotalElements());
        System.out.println(users.getTotalPages());
        System.out.println(users.getNumberOfElements());
        System.out.println(users.getSort());
        System.out.println(users.getSize());
        */

        /*
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email",endsWith());

        Example<Users> example = Example.of(new Users("ma","fastcampus.com"),matcher);
        userRepository.findAll(example).forEach(System.out::println);
         */


        //like 양방향 검색
        /*
        Users user = new Users();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email",contains());
        Example<Users> example = Example.of(user,matcher);

        userRepository.findAll(example).forEach(System.out::println);
       */

        userRepository.save(new Users("david","david@fastcampus.com"));
        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);

    }



}