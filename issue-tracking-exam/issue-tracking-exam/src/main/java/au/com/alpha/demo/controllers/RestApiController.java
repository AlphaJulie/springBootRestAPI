package au.com.alpha.demo.controllers;

/**
 * Controller for issues rest api
 */

import au.com.alpha.demo.model.Issue;
import au.com.alpha.demo.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    IssueService issueService;

    // get all issues

    @RequestMapping(value = "/issue/", method = RequestMethod.GET)
    public ResponseEntity<List<Issue>> getAllIssues() {
        logger.info("Geting all Issues");
        List<Issue> issues =  issueService.findAll();
        return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
    }

    // get a particular issue by Id

    @RequestMapping(value = "/issue/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getIssue(@PathVariable("id") long id) {
        logger.info("Fetching Issue with id {}", id);
        Issue issue = issueService.findById(id);
        if (issue == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity("User with id " + id
                    + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Issue>(issue, HttpStatus.OK);

    }

    // create a new issue

    @RequestMapping(value = "/issue/", method = RequestMethod.POST)
    public ResponseEntity<?> createIssue(@RequestBody Issue issue, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Issue : {}", issue);

        issueService.insert(issue);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/issue/{id}").buildAndExpand(issue.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    // update a issue

    @RequestMapping(value = "/issue/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIssue(@RequestBody Issue issue, @PathVariable("id") long id) {
        logger.info("update Issue : {}", id);
        issue.setId(id);
        issueService.update(issue);
        return new ResponseEntity<Issue>(HttpStatus.NO_CONTENT);
    }

    // delete a issue

    @RequestMapping(value = "/issue/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIssue(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Issue with id {}", id);

        Issue issue = issueService.findById(id);
        if (issue == null) {
            logger.error("Unable to delete. Issue with id {} not found.", id);
            return new ResponseEntity("Unable to delete. Issue with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        issueService.deleteById(id);
        return new ResponseEntity<Issue>(HttpStatus.NO_CONTENT);
    }



}
