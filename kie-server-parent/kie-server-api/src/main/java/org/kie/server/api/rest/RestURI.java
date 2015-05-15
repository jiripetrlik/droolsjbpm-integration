package org.kie.server.api.rest;

import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

public class RestURI {

    //parameters
    public static final String CONTAINER_ID = "id";
    public static final String PROCESS_ID = "pId";
    public static final String PROCESS_INST_ID = "pInstanceId";
    public static final String SIGNAL_NAME = "sName";
    public static final String VAR_NAME = "varName";
    public static final String TASK_NAME = "taskName";
    public static final String TASK_INSTANCE_ID = "tInstanceId";
    public static final String CONTENT_ID = "contentId";
    public static final String COMMENT_ID = "commentId";
    public static final String ATTACHMENT_ID = "attachmentId";

    // uris
    // process related
    public static final String START_PROCESS_POST_URI = "containers/{" + CONTAINER_ID + "}/process/{" + PROCESS_ID +"}/instances";
    public static final String ABORT_PROCESS_INST_DEL_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID +"}";
    public static final String ABORT_PROCESS_INSTANCES_DEL_URI = "containers/{" + CONTAINER_ID + "}/process/instances";
    public static final String SIGNAL_PROCESS_INST_POST_URI = "containers/{" + CONTAINER_ID + "}/process/instance/" + PROCESS_INST_ID +"/signal/{" + SIGNAL_NAME + "}";
    public static final String SIGNAL_PROCESS_INSTANCES_PORT_URI = "containers/{" + CONTAINER_ID + "}/process/instances/signal/{" + SIGNAL_NAME + "}";
    public static final String PROCESS_INSTANCE_GET_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID + "}";
    public static final String PROCESS_INSTANCE_VAR_PUT_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID + "}/variable/{" + VAR_NAME + "}";
    public static final String PROCESS_INSTANCE_VARS_POST_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID + "}/variables";
    public static final String PROCESS_INSTANCE_VAR_GET_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID + "}/variable/{" + VAR_NAME + "}";
    public static final String PROCESS_INSTANCE_VARS_GET_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID + "}/variables";
    public static final String PROCESS_INSTANCE_SIGNALS_GET_URI = "containers/{" + CONTAINER_ID + "}/process/instance/{" + PROCESS_INST_ID + "}/signals";

    // process definition related
    public static final String PROCESS_DEF_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}";
    public static final String PROCESS_DEF_SUBPROCESS_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/subprocesses";
    public static final String PROCESS_DEF_VARIABLES_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/variables";
    public static final String PROCESS_DEF_SERVICE_TASKS_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/tasks/service";
    public static final String PROCESS_DEF_ASSOCIATED_ENTITIES_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/entities";
    public static final String PROCESS_DEF_USER_TASKS_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/tasks/user";
    public static final String PROCESS_DEF_USER_TASK_INPUT_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/tasks/user/{" + TASK_NAME + "}/inputs";
    public static final String PROCESS_DEF_USER_TASK_OUTPUT_GET_URI = "containers/{" + CONTAINER_ID + "}/process/definition/{" + PROCESS_ID +"}/tasks/user/{" + TASK_NAME + "}/outputs";

    // task related
    public static final String TASK_INSTANCE_ACTIVATE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/activated";
    public static final String TASK_INSTANCE_CLAIM_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/claimed";
    public static final String TASK_INSTANCE_START_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/started";
    public static final String TASK_INSTANCE_STOP_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/stopped";
    public static final String TASK_INSTANCE_COMPLETE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/completed";
    public static final String TASK_INSTANCE_DELEGATE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/delegated";
    public static final String TASK_INSTANCE_EXIT_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/exited";
    public static final String TASK_INSTANCE_FAIL_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/failed";
    public static final String TASK_INSTANCE_FORWARD_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/forwarded";
    public static final String TASK_INSTANCE_RELEASE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/released";
    public static final String TASK_INSTANCE_RESUME_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/resumed";
    public static final String TASK_INSTANCE_SKIP_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/skipped";
    public static final String TASK_INSTANCE_SUSPEND_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/suspended";
    public static final String TASK_INSTANCE_NOMINATE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/states/nominated";

    public static final String TASK_INSTANCE_PRIORITY_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/priority";
    public static final String TASK_INSTANCE_DESCRIPTION_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/description";
    public static final String TASK_INSTANCE_NAME_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/name";
    public static final String TASK_INSTANCE_EXPIRATION_DATE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/expiration";
    public static final String TASK_INSTANCE_SKIPABLE_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/skipable";

    public static final String TASK_INSTANCE_OUTPUT_DATA_PUT_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/content/output";
    public static final String TASK_INSTANCE_OUTPUT_DATA_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/content/output";
    public static final String TASK_INSTANCE_INPUT_DATA_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/content/input";

    public static final String TASK_INSTANCE_CONTENT_DATA_DELETE_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/content/{" + CONTENT_ID +"}";

    public static final String TASK_INSTANCE_COMMENT_ADD_POST_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/comments";
    public static final String TASK_INSTANCE_COMMENTS_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/comments";
    public static final String TASK_INSTANCE_COMMENT_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/comments/{" + COMMENT_ID + "}";
    public static final String TASK_INSTANCE_COMMENT_DELETE_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/comments/{" + COMMENT_ID + "}";

    public static final String TASK_INSTANCE_ATTACHMENT_ADD_POST_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/attachments";
    public static final String TASK_INSTANCE_ATTACHMENTS_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/attachments";
    public static final String TASK_INSTANCE_ATTACHMENT_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/attachments/{" + ATTACHMENT_ID + "}";
    public static final String TASK_INSTANCE_ATTACHMENT_CONTENT_GET_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/attachments/{" + ATTACHMENT_ID + "}/content";
    public static final String TASK_INSTANCE_ATTACHMENT_DELETE_URI = "containers/{" + CONTAINER_ID + "}/tasks/{" + TASK_INSTANCE_ID + "}/attachments/{" + ATTACHMENT_ID + "}";


    // task search related
    public static final String TASKS_ASSIGN_POT_OWNERS_GET_URI = "containers/{" + CONTAINER_ID + "}/task/instances";

    public static String build(String baseUrl, String template, Map<String, Object> parameters) {
        StrSubstitutor sub = new StrSubstitutor(parameters, "{", "}");
        String resourceUrl = sub.replace(template);

        return baseUrl + "/" + resourceUrl;
    }
}
