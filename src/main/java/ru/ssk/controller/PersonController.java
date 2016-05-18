package ru.ssk.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.ssk.model.PhysicalPerson;
import ru.ssk.service.OwnerService;
import ru.ssk.service.PhysicalPersonService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 18.05.16.
 */
@RestController
@RequestMapping("/persons")
@Transactional
public class PersonController extends BaseController {
    @Autowired
    PhysicalPersonService personService;
    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/table/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PhysicalPerson> allAddresses(){
        return personService.findAll();
    }

    @RequestMapping(value = "/editor/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PhysicalPerson getOne(@RequestParam(value = "id") long id){
        return personService.findById(id);
    }

    @RequestMapping(value = "/table/", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestParam(value = "ids") Long[] idsToDelete) {

        if (idsToDelete.length > 0) {
            ownerService.deleteOwnersWithIds(Arrays.asList(idsToDelete));
            return new Gson().toJson("Записи успешно удалены.");
        } else {
            return new Gson().toJson("Не выбраны записи для удаления.");
        }
    }

    @RequestMapping(value = "/editor/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestParam(value = "id") long id,
                         @RequestParam(value = "person") String person) {
        Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        PhysicalPerson physicalPerson = gson.fromJson(person, PhysicalPerson.class);
        physicalPerson.setId(id);
        personService.save(physicalPerson);
        return new Gson().toJson("Запись успешно обновлена.");
    }

    @RequestMapping(value = "/editor/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String add(@RequestParam(value = "person") String person) {
        Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        PhysicalPerson physicalPerson = gson.fromJson(person, PhysicalPerson.class);
        personService.save(physicalPerson);
        return new Gson().toJson("Данные о физ. лице успешно сохранены в базе.");
    }
}