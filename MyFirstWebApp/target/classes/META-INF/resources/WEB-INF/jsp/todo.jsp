
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter ToDo Details</h1><br><br>
    
    <!-- Form for adding a new ToDo -->
    <form action="add-todo" method="post">
        
        <!-- Label and input field for description -->
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <input type="text" class="form-control" id="description" name="description" required>
        </div>
        
        <!-- Label and input field for targetDate -->
        <div class="mb-3">
            <label for="targetDate">Target Date:</label>
            <input type="text" class="form-control" id="targetDate" name="targetDate" required>
        </div>
        
        <!-- Submit button to send the form data -->
        <button type="submit" class="btn btn-primary">Add ToDo</button>
    </form>
</div>

<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
});
</script>



