import org.gitlab.api.GitlabAPI
import org.junit.Before
import org.junit.Test

class GitlabMRTest {
    GitlabAPI api;

    @Before
    public void setup() {
        api = GitlabAPI.connect("http://wpsgit.kingsoft.net", "gid46Y9qHTMjGcA1byUC");
    }

    @Test
    void testMergeRequest() {
        def prjLst = api.getAllProjects()
        def prj = prjLst.find{ prj -> prj.getPathWithNamespace() == 'wangdong/engine' }
        def mrLst = api.getOpenMergeRequests(prj)
        def m = mrLst[0]

        println api.getAllNotes(m)[-1].getAuthor().getName()
    }
}
